class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        int row = 0;
        int col = 0;
        
        for (int num : original) {            
            if (row >= m) {
                return new int[0][0];
            }
            
            result[row][col++] = num;
            
            if (col == n) {
                row++;
                col = 0;
            }
        }
        
        if (result[m - 1][n - 1] == 0) {
            return new int[0][0];
        } 
        
        return result;
    }
}