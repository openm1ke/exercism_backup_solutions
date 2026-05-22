class NucleotideCount {
  Map<String, int> count(String s) {
    final check = 'ACGT';
    final map = {'A':0,'C':0,'G':0,'T':0};
    s.toUpperCase().split("").forEach((ch){
      if (!check.contains(ch)) throw InvalidNucleotideException();
      map.update(ch, (v) => v + 1);
    });
    return map;
  }
}

class InvalidNucleotideException implements Exception {
  final String message;
  const InvalidNucleotideException([this.message = 'Invalid nucleotide']);
  @override
  String toString() => message;
}
