// Put your code here
int score(String s) {
  final scores = {
    1: ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'],
    2: ['D', 'G'],
    3: ['B', 'C', 'M', 'P'],
    4: ['F', 'H', 'V', 'W', 'Y'],
    5: ['K'],
    8: ['J', 'X'],
    10: ['Q', 'Z']
  };
  int total = 0;

  for (final letter in s.toUpperCase().split('')) {
    for (final entry in scores.entries) {
      if (entry.value.contains(letter)) {
        total += entry.key;
        break;
      }
    }
  }

  return total;
}