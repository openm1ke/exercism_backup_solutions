class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String clean = stringToVerify.replaceAll("-", "").toUpperCase();

        if (clean.length() != 10) {
            return false;
        }
        
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            char c = clean.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            int digit = Character.getNumericValue(c);
            sum += digit * (10 - i);
        }

        char lastChar = clean.charAt(9);
        if (lastChar != 'X' && !Character.isDigit(lastChar)) {
            return false;
        }

        sum += (lastChar == 'X') ? 10 : Character.getNumericValue(lastChar);
        return sum % 11 == 0;
    }
}
