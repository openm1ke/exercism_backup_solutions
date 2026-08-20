class Bob {

  List<String> answers = [
    "Sure.",
    "Whoa, chill out!",
    "Calm down, I know what I'm doing!",
    "Fine. Be that way!",
    "Whatever."
  ];

  String response(String message) {
    final trimmed = message.trim();
    if (trimmed.isEmpty) return answers[3];

    final isQuestion = trimmed.endsWith('?');
    final isShouting = _isShouting(trimmed);

    if (isShouting && isQuestion) return answers[2];
    if (isShouting) return answers[1];
    if (isQuestion) return answers[0];

    return answers[4];
  }

  bool _isShouting(String text) {
    return RegExp(r'[A-Za-z]').hasMatch(text) &&
        text == text.toUpperCase();
  }
}
