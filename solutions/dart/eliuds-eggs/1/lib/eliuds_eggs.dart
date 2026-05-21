class EggCounter {
  // Your code goes here.
  int count(int i) {
    int count = 0;
    String bin = i.toRadixString(2);
    bin.split("").forEach((ch) {
      if (ch == '1') count++;
    });
    return count;
  }
}
