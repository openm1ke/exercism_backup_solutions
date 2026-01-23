class GameOfLife {
    public int[][] tick(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[][]{};
        }
        int[][] new_matrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int current = matrix[i][j];
                int neighbors = count_closes(i, j, matrix);
                if (current == 0 && neighbors == 3) {
                    new_matrix[i][j] = 1;
                } else if (current == 1 && (neighbors < 2 || neighbors > 3)) {
                    new_matrix[i][j] = 0;
                } else {
                    new_matrix[i][j] = current;
                }
            }
        }
        return new_matrix;
    }

    private int count_closes(int x, int y, int[][] matrix) {
        int HEIGHT = matrix.length;
        int WIDTH = matrix[0].length;
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int row = x + i;
                int col = y + j;
                if (i == 0 && j == 0) continue;
                if (row >= 0 && row < HEIGHT && col >= 0 && col < WIDTH) {
                    count += matrix[row][col];
                }
            }
        }
        return count;
    }
}
