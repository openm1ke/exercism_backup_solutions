import java.util.Map;

class RomanNumerals {
    private int number;
    private final Map<Integer, String> arabicToRoman = Map.ofEntries(
            Map.entry(1, "I"),
            Map.entry(4, "IV"),
            Map.entry(5, "V"),
            Map.entry(8, "VIII"),
            Map.entry(9, "IX"),
            Map.entry(10, "X"),
            Map.entry(40, "XL"),
            Map.entry(50, "L"),
            Map.entry(90, "XC"),
            Map.entry(100, "C"),
            Map.entry(400, "CD"),
            Map.entry(500, "D"),
            Map.entry(900, "CM"),
            Map.entry(1000, "M")
    );

    RomanNumerals(int number) {
        this.number = number;
    }

    String getRomanNumeral() {
        StringBuilder roman = new StringBuilder();
        while (number > 0) {

            int biggestKey = 0;

            for (Integer key : arabicToRoman.keySet()) {
                if (key <= number && key > biggestKey) {
                    biggestKey = key;
                }
            }
            roman.append(arabicToRoman.get(biggestKey));
            number -= biggestKey;
        }
        return roman.toString();
    }
}
