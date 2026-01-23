class IsogramChecker {

    boolean isIsogram(String phrase) {
        String lowerPhrase = phrase.toLowerCase();
        for (int i = 0; i < lowerPhrase.length(); i++) {
            char c = lowerPhrase.charAt(i);
            if (c != ' ' && c != '-' && lowerPhrase.indexOf(c, i + 1) != -1) {
                return false;
            }
        }
        return true;
    }

}
