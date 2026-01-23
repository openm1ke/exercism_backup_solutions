public class Say {

    private static final String[] SMALL = {
            "zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] SCALE = {
            "", "thousand", "million", "billion"
    };

    public String say(long number) {
        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException("Number out of range");
        }

        if (number == 0) {
            return "zero";
        }

        StringBuilder result = new StringBuilder();
        int scaleIndex = 0;

        while (number > 0) {
            int chunk = (int) (number % 1000);
            if (chunk != 0) {
                String chunkWords = sayBelowThousand(chunk);

                if (!SCALE[scaleIndex].isEmpty()) {
                    chunkWords = chunkWords + " " + SCALE[scaleIndex];
                }

                if (result.length() == 0) {
                    result.append(chunkWords);
                } else {
                    result.insert(0, chunkWords + " ");
                }
            }

            number /= 1000;
            scaleIndex++;
        }

        return result.toString();
    }

    private String sayBelowThousand(int n) {
        StringBuilder words = new StringBuilder();

        if (n >= 100) {
            int hundreds = n / 100;
            words.append(SMALL[hundreds]).append(" hundred");
            n %= 100;
            if (n > 0) {
                words.append(" ");
            }
        }

        if (n >= 20) {
            int tens = n / 10;
            int ones = n % 10;

            words.append(TENS[tens]);
            if (ones > 0) {
                words.append("-").append(SMALL[ones]);
            }
        } else if (n > 0) {
            words.append(SMALL[n]);
        }

        return words.toString();
    }
}
