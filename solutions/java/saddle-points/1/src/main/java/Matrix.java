import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    private final int[][] matrix;
    private final int rows;
    private final int cols;

    Matrix(List<List<Integer>> values) {
        this.rows = values.size();
        this.cols = (rows == 0) ? 0 : values.getFirst().size();
        this.matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.matrix[i][j] = values.get(i).get(j);
            }
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        if (rows == 0 || cols == 0) {
            return saddlePoints;
        }

        int[] rowMax = new int[rows];
        int[] colMin = new int[cols];
        Arrays.fill(rowMax, Integer.MIN_VALUE);
        Arrays.fill(colMin, Integer.MAX_VALUE);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int v = this.matrix[r][c];
                if (v > rowMax[r]) rowMax[r] = v;
                if (v < colMin[c]) colMin[c] = v;
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int v = this.matrix[r][c];
                if (v ==  rowMax[r] && v == colMin[c]) {
                    saddlePoints.add(new MatrixCoordinate(r + 1, c + 1));
                }
            }
        }

        return saddlePoints;
    }
}
