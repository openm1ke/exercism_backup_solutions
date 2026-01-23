import java.util.List;
import java.util.Map;

class Scrabble {

    private int score = 0;

    private Map<Integer, List<Character>> scoreMap = Map.of(
        1, List.of('a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't'),
        2, List.of('d', 'g'),
        3, List.of('b', 'c', 'm', 'p'),
        4, List.of('f', 'h', 'v', 'w', 'y'),
        5, List.of('k'),
        8, List.of('j', 'x'),
        10, List.of('q', 'z')
    );

    Scrabble(String word) {
        for(char c : word.toLowerCase().toCharArray()) {
            score += scoreMap.entrySet().stream().filter(e -> e.getValue().contains(c)).findFirst().get().getKey();
        }
    }

    int getScore() {
        return score;
    }

}
