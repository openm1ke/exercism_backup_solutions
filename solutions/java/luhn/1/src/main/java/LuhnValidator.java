import java.util.Objects;

class LuhnValidator {

    boolean isValid(String candidate) {
        if (!candidate.chars().allMatch(ch -> Character.isDigit(ch) || ch == ' ')) {
            return false;
        }
        String trimmed = candidate.replace(" ", "");
        if (trimmed.length() <= 1) return false;
        int sum = 0;
        boolean doubleIt = false;

        for (int i = trimmed.length() - 1; i >= 0; i--) {
            int digit = trimmed.charAt(i) - '0';

            if (doubleIt) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }

            sum += digit;
            doubleIt = !doubleIt;
        }

        return sum % 10 == 0;
    }
}
