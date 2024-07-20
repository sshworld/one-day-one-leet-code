class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];
        
        for(int i = 0; i < rowSum.length; i++) {
            for(int j = 0; j < colSum.length; j++) {
                int num = Math.min(rowSum[i], colSum[j]);
                
                rowSum[i] -= num;
                colSum[j] -= num;
                result[i][j] = num;
            }
        }
        
        return result;
    }
}