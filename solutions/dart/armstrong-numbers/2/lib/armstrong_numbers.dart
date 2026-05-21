class ArmstrongNumbers {
  bool isArmstrongNumber(String s) {
    final power = s.length;
    var sum = BigInt.zero;

    for (final ch in s.split('')) {
      final digit = BigInt.from(int.parse(ch));
      sum += digit.pow(power);
    }

    return sum == BigInt.parse(s);
  }
}
