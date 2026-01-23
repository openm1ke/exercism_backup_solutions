import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.isLetter;

public class PangramChecker {

    public boolean isPangram(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toLowerCase().toCharArray()) {
            if (isLetter(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map.size() == 26;
    }

}
