import java.text.BreakIterator;

class MicroBlog {
    public String truncate(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        BreakIterator iterator = BreakIterator.getCharacterInstance();
        iterator.setText(input);

        int count = 0;
        int end = 0;

        while (iterator.next() != BreakIterator.DONE) {
            count++;
            if (count > 5) {
                break;
            }
            end = iterator.current();
        }

        return input.substring(0, end);
    }
}
