class GameOfLife {
  // The leading underscore makes this field private to this Dart library.
  List<List<int>> _matrix;

  // this._matrix is shorthand for assigning the constructor argument
  // directly to the private _matrix field.
  GameOfLife(this._matrix);


  // Build the next generation from the current matrix.
  void tick() {
    // return of empty
    if (_matrix.isEmpty) return;
    // get rows and cols
    final rows = _matrix.length;
    final cols = _matrix[0].length;

    // Start with a dead grid of the same size.
    final next = List.generate(rows, (_) => List.filled(cols, 0));
    // every cell checking for neighbors and set alive
    for (var row = 0; row < rows; row++) {
      for (var col = 0; col < cols; col++) {
        // Count live neighbors before changing the current cell.
        final liveNeighbors = _countLiveNeighbors(row, col);
        final isAlive = _matrix[row][col] == 1;

        // A cell is alive in the next generation if it has 3 live neighbors,
        // or if it is already alive and has exactly 2 live neighbors.
        if (liveNeighbors == 3 || (isAlive && liveNeighbors == 2)) {
          next[row][col] = 1;
        }
      }
    }

    // Replace the old generation only after all cells have been calculated.
    _matrix = next;
  }

  int _countLiveNeighbors(int row, int col) {
    var count = 0;

    // Check all 8 surrounding positions around the given cell.
    for (var rowOffset = -1; rowOffset <= 1; rowOffset++) {
      for (var colOffset = -1; colOffset <= 1; colOffset++) {
        // Skip the cell itself.
        if (rowOffset == 0 && colOffset == 0) continue;

        final neighborRow = row + rowOffset;
        final neighborCol = col + colOffset;

        // Ignore neighbors that are outside the matrix.
        if (neighborRow < 0 ||
            neighborRow >= _matrix.length ||
            neighborCol < 0 ||
            neighborCol >= _matrix[neighborRow].length) {
          continue;
        }

        // Add 1 for a live neighbor and 0 for a dead neighbor.
        count += _matrix[neighborRow][neighborCol];
      }
    }

    return count;
  }

  List<List<int>> matrix() => _matrix;
}
