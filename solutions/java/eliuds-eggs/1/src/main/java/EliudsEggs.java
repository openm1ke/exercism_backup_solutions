public class EliudsEggs {
    public int eggCount(int number) {
        if (number < 0) throw new IllegalArgumentException("Only non-negative numbers are allowed");
        return (int) Integer.toBinaryString(number).chars().filter(c -> c == '1').count();
    }
}
