class WordCount {
  Map<String, int> countWords(String phrase) {
    final result = <String, int>{};
    final matches = RegExp(r"[a-zA-Z0-9]+(?:'[a-zA-Z0-9]+)?").allMatches(phrase);

    for (final match in matches) {
      final word = match.group(0)!.toLowerCase();
      result[word] = result.putIfAbsent(word, () => 0) + 1;
    }
    return result;
  }
}
