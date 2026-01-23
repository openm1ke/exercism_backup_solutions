class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for (char c : identifier.toCharArray()) {
            if (c == '-') {
                // Convert kebab-case to camelCase
                capitalizeNext = true;
            } else if (c == ' ') {
                // Replace spaces with underscores
                result.append('_');
            } else if (Character.isDigit(c)) {
                // Convert leetspeak to normal text
                switch (c) {
                    case '4': result.append('a'); break;
                    case '3': result.append('e'); break;
                    case '0': result.append('o'); break;
                    case '1': result.append('l'); break;
                    case '7': result.append('t'); break;
                    default: break;
                }
            } else if (Character.isLetter(c)) {
                // Only allow letters and apply camelCase capitalization if needed
                result.append(capitalizeNext ? Character.toUpperCase(c) : c);
                capitalizeNext = false;
            }
        }

        return result.toString();
    }
}
