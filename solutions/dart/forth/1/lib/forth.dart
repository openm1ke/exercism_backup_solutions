class Forth {
  List<int> stack = [];
  Map<String, List<String>> dict = {};

  void evaluate(String s) {
    if (s.trim().isEmpty) return;

    final tokens = s.trim().split(RegExp(r'\s+'));

    for (var i = 0; i < tokens.length; i++) {
      final token = tokens[i].toLowerCase();

      if (token == ':') {
        if (i + 1 >= tokens.length) {
          throw Exception('Invalid definition');
        }

        final name = tokens[++i].toLowerCase();
        if (int.tryParse(name) != null || name == ':' || name == ';') {
          throw Exception('Invalid definition');
        }

        final body = <String>[];
        while (++i < tokens.length && tokens[i] != ';') {
          final word = tokens[i].toLowerCase();
          if (dict.containsKey(word)) {
            body.addAll(dict[word]!);
          } else {
            body.add(word);
          }
        }

        if (i >= tokens.length) {
          throw Exception('Invalid definition');
        }

        dict[name] = body;
      } else {
        _executeToken(token);
      }
    }
  }

  void _executeToken(String token) {
    final number = int.tryParse(token);
    if (number != null) {
      stack.add(number);
      return;
    }

    if (dict.containsKey(token)) {
      for (final word in dict[token]!) {
        _executeToken(word);
      }
      return;
    }

    switch (token) {
      case '+':
        final values = _takeTwo();
        stack.add(values.left + values.right);
      case '-':
        final values = _takeTwo();
        stack.add(values.left - values.right);
      case '*':
        final values = _takeTwo();
        stack.add(values.left * values.right);
      case '/':
        final values = _takeTwo();
        if (values.right == 0) throw Exception('Division by zero');
        stack.add(values.left ~/ values.right);
      case 'dup':
        stack.add(_takeOne());
      case 'drop':
        _takeOne();
        stack.removeLast();
      case 'swap':
        final values = _takeTwo();
        stack.add(values.right);
        stack.add(values.left);
      case 'over':
        final values = _takeTwo();
        stack.add(values.left);
        stack.add(values.right);
        stack.add(values.left);
      default:
        throw Exception('Unknown command');
    }
  }

  int _takeOne() {
    if (stack.length < 1) {
      throw Exception('Stack empty');
    }
    return stack.last;
  }

  ({int left, int right}) _takeTwo() {
    if (stack.length < 2) {
      throw Exception('Stack empty');
    }
    final right = stack.removeLast();
    final left = stack.removeLast();
    return (left: left, right: right);
  }
}
