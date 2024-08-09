class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private boolean isMagicSquare(int[][] grid, int row, int col) {
        Set<Integer> numbers = new HashSet<>();
        
        int sum = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        
        for (int i = row; i < row + 3; i++) {
            int tempSum = 0;
            
            for (int j = col; j < col + 3; j++) {
                tempSum += grid[i][j];
                numbers.add(grid[i][j]);
                
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false;
                }
            }
            
            if (sum != tempSum) {
                return false;
            }
        }
        
        if (numbers.size() != 9) {
            return false;
        }
        
        for (int i = col; i < col + 3; i++) {
            int tempSum = 0;
            
            for (int j = row; j < row + 3; j++) {
                tempSum += grid[j][i];
            }
            
            if (sum != tempSum) {
                return false;
            }
        }
        
        if (sum != grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2]) {
            return false;
        }
        
        return true;
    }
}