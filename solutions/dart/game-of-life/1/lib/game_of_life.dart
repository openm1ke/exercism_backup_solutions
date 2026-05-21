class GameOfLife {
  List<List<int>> cells = [];

  GameOfLife(this.cells);

  void tick() {
    if (cells.isEmpty) return;

    final rows = cells.length;
    final cols = cells[0].length;

    final next = List.generate(
      rows,
          (_) => List.filled(cols, 0),
    );

    for (var row = 0; row < rows; row++) {
      for (var col = 0; col < cols; col++) {
        final liveNeighbors = _countLiveNeighbors(row, col);
        final isAlive = cells[row][col] == 1;

        if (isAlive && (liveNeighbors == 2 || liveNeighbors == 3)) {
          next[row][col] = 1;
        } else if (!isAlive && liveNeighbors == 3) {
          next[row][col] = 1;
        }
      }
    }

    cells = next;
  }

  int _countLiveNeighbors(int row, int col) {
    var count = 0;

    for (var rowOffset = -1; rowOffset <= 1; rowOffset++) {
      for (var colOffset = -1; colOffset <= 1; colOffset++) {
        if (rowOffset == 0 && colOffset == 0) continue;

        final neighborRow = row + rowOffset;
        final neighborCol = col + colOffset;

        if (neighborRow < 0 ||
            neighborRow >= cells.length ||
            neighborCol < 0 ||
            neighborCol >= cells[neighborRow].length) {
          continue;
        }

        count += cells[neighborRow][neighborCol];
      }
    }

    return count;
  }

  List<List<int>> matrix() {
    return cells;
  }
}
