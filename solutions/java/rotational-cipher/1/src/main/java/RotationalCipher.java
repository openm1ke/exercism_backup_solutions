class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey % 26;
    }

    String rotate(String data) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isLowerCase(c)) {
                char shifted = (char) ('a' + (c - 'a' + shiftKey) % 26);
                result.append(shifted);
            } else if (Character.isUpperCase(c)) {
                char shifted = (char) ('A' + (c - 'A' + shiftKey) % 26);
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
