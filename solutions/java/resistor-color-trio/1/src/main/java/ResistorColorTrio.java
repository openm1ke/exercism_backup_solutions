import java.util.HashMap;
import java.util.LinkedHashMap;

class ResistorColorTrio {

    private final HashMap<String, Integer> colorMap;

    public ResistorColorTrio() {
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

    String label(String[] colors) {
        int firstDigit = colorMap.get(colors[0]);
        int secondDigit = colorMap.get(colors[1]);
        int multiplier = colorMap.get(colors[2]);

        long resistance = (long) ((firstDigit * 10L + secondDigit) * Math.pow(10, multiplier));

        if (resistance >= 1_000_000_000 && resistance % 1_000_000_000 == 0) {
            return (resistance / 1_000_000_000) + " gigaohms";
        } else if (resistance >= 1_000_000 && resistance % 1_000_000 == 0) {
            return (resistance / 1_000_000) + " megaohms";
        } else if (resistance >= 1_000 && resistance % 1_000 == 0) {
            return (resistance / 1_000) + " kiloohms";
        } else {
            return resistance + " ohms";
        }
    }
}
