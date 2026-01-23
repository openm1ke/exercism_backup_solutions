import java.util.Objects;

class ArmstrongNumbers {
    boolean isArmstrongNumber(int numberToCheck) {
        char[] bytes = Objects.toString(numberToCheck).toCharArray();
        int len = bytes.length;
        int result = 0;
        for (char aByte : bytes) {
            result += (int) Math.pow(aByte - '0', len);
        }
        return result == numberToCheck;
    }
}
