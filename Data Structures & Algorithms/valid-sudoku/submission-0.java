class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> squares = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            squares.put(i, new HashSet<>());
        }
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int val = Character.getNumericValue(board[r][c]);
                System.out.println("val : " + val);
                // check if row contains val
                Set<Integer> rowSet = rows.get(r);
                if (rowSet.contains(val)) {
                    return false;
                } else {
                    rowSet.add(val);
                }

                // check if col contains val
                Set<Integer> colSet = cols.get(c);
                if (colSet.contains(val)) {
                    return false;
                } else {
                    colSet.add(val);
                }

                // check if squares contains val
                int square = determineSquare(r, c);
                Set<Integer> squareSet = squares.get(square);
                if (squareSet.contains(val)) {
                    return false;
                } else {
                    squareSet.add(val);
                }
            }
        }
        return true;
    }

    public int determineSquare(int r, int c) {
        if (r >= 0 && r <= 2 && c >= 0 && c <= 2) {
            return 0;
        } else if (r >= 0 && r <= 2 && c >= 3 && c <= 5) {
            return 1;
        } else if (r >= 0 && r <= 2 && c >= 6 && c <= 8) {
            return 2;
        } else if (r >= 3 && r <= 5 && c >= 0 && c <= 2) {
            return 3;
        } else if (r >= 3 && r <= 5 && c >= 3 && c <= 5) {
            return 4;
        } else if (r >= 3 && r <= 5 && c >= 6 && c <= 8) {
            return 5;
        } else if (r >= 6 && r <= 8 && c >= 0 && c <= 2) {
            return 6;
        } else if (r >= 6 && r <= 8 && c >= 3 && c <= 5) {
            return 7;
        } else {
            return 8;
        }
    }
}
