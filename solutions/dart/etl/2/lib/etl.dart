class Etl {
  // Put your code here
  Map<String, int> transform(Map<String, List<String>> map) {
    final res = <String, int>{};
    for (final el in map.entries) {
      final score = int.parse(el.key);
      for (final v in el.value) {
        res[v.toLowerCase()] = score;
      }
    }
    return res;
  }
}
