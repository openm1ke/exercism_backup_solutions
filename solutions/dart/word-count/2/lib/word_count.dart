class WordCount {
  Map<String, int> countWords(String phrase) {
    final result = <String, int>{};
    final matches = RegExp(r"(\w+('\w+)?)").allMatches(phrase.toLowerCase());
    for (final match in matches) {
      final word = match.group(0)!;
      result[word] = result.putIfAbsent(word, () => 0) + 1;
    }
    return result;
  }
}
