import 'package:decimal/decimal.dart';

class ArmstrongNumbers {
  bool isArmstrongNumber(String s) {
    final power = s.length;
    var sum = Decimal.zero;

    for (final ch in s.split('')) {
      final digit = Decimal.fromInt(int.parse(ch));
      sum += _pow(digit, power);
    }

    return sum == Decimal.parse(s);
  }

  Decimal _pow(Decimal base, int exponent) {
    var result = Decimal.one;

    for (var i = 0; i < exponent; i++) {
      result *= base;
    }

    return result;
  }
}
