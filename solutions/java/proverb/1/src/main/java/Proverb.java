import java.util.LinkedHashMap;
import java.util.Map;

class Proverb {

    private final Map<String, String> pairs = new LinkedHashMap<>();
    private final String firstWord;

    Proverb(String[] words) {
        if (words.length == 0) {
            firstWord = null;
            return;
        }

        firstWord = words[0];
        for (int i = 0; i < words.length - 1; i++) {
            pairs.put(words[i], words[i + 1]);
        }
    }

    String recite() {
        if (firstWord == null) return "";

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> e : pairs.entrySet()) {
            sb.append("For want of a ")
                    .append(e.getKey())
                    .append(" the ")
                    .append(e.getValue())
                    .append(" was lost.\n");
        }
        sb.append("And all for the want of a ").append(firstWord).append(".");
        return sb.toString();
    }

}
