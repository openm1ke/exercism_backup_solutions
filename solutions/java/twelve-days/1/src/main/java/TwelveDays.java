class TwelveDays {
    private static final String[] ORDINALS = {
            "first",
            "second",
            "third",
            "fourth",
            "fifth",
            "sixth",
            "seventh",
            "eighth",
            "ninth",
            "tenth",
            "eleventh",
            "twelfth"
    };

    private static final String[] GIFTS = {
            "a Partridge in a Pear Tree",
            "two Turtle Doves",
            "three French Hens",
            "four Calling Birds",
            "five Gold Rings",
            "six Geese-a-Laying",
            "seven Swans-a-Swimming",
            "eight Maids-a-Milking",
            "nine Ladies Dancing",
            "ten Lords-a-Leaping",
            "eleven Pipers Piping",
            "twelve Drummers Drumming"
    };

    String verse(int verseNumber) {
        StringBuilder verse = new StringBuilder("On the ")
                .append(ORDINALS[verseNumber - 1])
                .append(" day of Christmas my true love gave to me: ");

        for (int giftNumber = verseNumber; giftNumber >= 1; giftNumber--) {
            if (giftNumber < verseNumber) {
                verse.append(", ");
            }

            if (giftNumber == 1 && verseNumber > 1) {
                verse.append("and ");
            }

            verse.append(GIFTS[giftNumber - 1]);
        }

        return verse.append(".\n").toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder verses = new StringBuilder();

        for (int verseNumber = startVerse; verseNumber <= endVerse; verseNumber++) {
            if (verseNumber > startVerse) {
                verses.append("\n");
            }

            verses.append(verse(verseNumber));
        }

        return verses.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }
}
