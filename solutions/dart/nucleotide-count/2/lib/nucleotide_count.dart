class NucleotideCount {
  Map<String, int> count(String s) {
    final map = {'A':0,'C':0,'G':0,'T':0};
    s.toUpperCase().split("").forEach((ch) {
      map.update(ch, (v) => v + 1,
      ifAbsent: () => throw InvalidNucleotideException());
    });
    return map;
  }
}

class InvalidNucleotideException implements Exception {
  final String _message;
  const InvalidNucleotideException([this._message = 'Invalid nucleotide']);
  @override
  String toString() => _message;
}
