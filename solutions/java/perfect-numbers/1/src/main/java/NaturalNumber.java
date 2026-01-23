class NaturalNumber {

    private final int value;
    private int sum;

    NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        value = number;
        for  (int i = 1; i < value; i++) {
            if (value % i == 0) {
                sum += i;
            }
        }
    }

    Classification getClassification() {
        if (sum == value) return Classification.PERFECT;
        else if (sum < value) return Classification.DEFICIENT;
        else return Classification.ABUNDANT;
    }
}
