import java.util.List;

class Acronym {
    private final String phrase;
    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        String temp = phrase.replaceAll("[^a-zA-Z\\s-]", "").toUpperCase();
        StringBuilder sb = new StringBuilder();

        for (String word : temp.split("[\\s-]+")) { // разбиваем по пробелам и дефисам
            if (!word.isEmpty()) {
                sb.append(word.charAt(0));
            }
        }
        return sb.toString();
    }
}
