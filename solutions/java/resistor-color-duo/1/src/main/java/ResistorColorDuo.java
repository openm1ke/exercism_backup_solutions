import java.util.HashMap;
import java.util.LinkedHashMap;

class ResistorColorDuo {

    private final HashMap<String, Integer> colorMap;

    public ResistorColorDuo() {
        colorMap = new LinkedHashMap<>();
        colorMap.put("black", 0);
        colorMap.put("brown", 1);
        colorMap.put("red", 2);
        colorMap.put("orange", 3);
        colorMap.put("yellow", 4);
        colorMap.put("green", 5);
        colorMap.put("blue", 6);
        colorMap.put("violet", 7);
        colorMap.put("grey", 8);
        colorMap.put("white", 9);
    }

    int value(String[] colors) {
        int result = 0;
        for (int i = 0; i < colors.length; i++) {
            if (i >= 2) break;
            result = result * 10 + colorMap.get(colors[i]);
        }
        return result;
    }
}
