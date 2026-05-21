class HighScores {
  List<int> _scores;

  HighScores(this._scores);

  List<int> get scores => List.unmodifiable(_scores);

  int latest() => _scores.last;

  int personalBest() => _scores.reduce((a, b) => a > b ? a : b);

  List<int> personalTopThree() => ([..._scores]..sort((a, b) => b.compareTo(a))).take(3).toList();
}
