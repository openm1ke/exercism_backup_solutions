import java.util.ArrayList;
import java.util.List;

public class KillerSudokuHelper {

    private static final List<Integer> ALL_SUDOKU_NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<Integer> nums = new ArrayList<>(ALL_SUDOKU_NUMBERS);
        if (exclude != null) {
            nums.removeAll(exclude);
        }
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(nums, cageSum, cageSize, 0, new ArrayList<>(), result);
        return result;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return combinationsInCage(cageSum, cageSize, null);
    }
    
    private void findCombinations(List<Integer> nums, int cageSum, int cageSize, int start,
                                 List<Integer> current, List<List<Integer>> result) {
        if (current.size() == cageSize) {
            if (cageSum == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        
        for (int i = start; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num > cageSum) {
                continue;
            }

            current.add(num);
            findCombinations(nums, cageSum - num, cageSize, i + 1, current, result);
            current.removeLast();
        }
    }

}
