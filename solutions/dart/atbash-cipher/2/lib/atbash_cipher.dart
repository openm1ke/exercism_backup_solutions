class AtbashCipher {
  static const String _letters = "abcdefghijklmnopqrstuvwxyz0123456789";
  static const String _cipher = "zyxwvutsrqponmlkjihgfedcba0123456789";

  String encode(String s, {bool decode = false}) {
    final buffer = StringBuffer();
    int count = 0;
    s.toLowerCase().split("").forEach((ch) {
      var index = _letters.indexOf(ch);
      if (index == -1) return;
      if (count > 0 && count % 5 == 0 && decode == false) {
        buffer.write(" ");
      }
      buffer.write(_cipher[index]);
      count++;
    });

    return buffer.toString();
  }

  String decode(String s) {
    return encode(s, decode: true);
  }
}
