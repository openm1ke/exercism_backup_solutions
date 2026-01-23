import java.util.stream.Gatherers;
import java.util.stream.Stream;

class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.isEmpty() && !inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        if (inputNumber.length() < numberOfDigits) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        Stream<Long> characterStream = inputNumber.chars().mapToObj(c -> (long)(c - '0'));
        return characterStream.gather(Gatherers.windowSliding(numberOfDigits))
                .mapToLong(window -> window.stream().reduce(1L, (a, b) -> a * b))
                .max()
                .orElse(0);
    }
}
