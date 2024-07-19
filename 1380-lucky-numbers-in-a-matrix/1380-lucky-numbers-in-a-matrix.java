class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] transposeMatrix = new int[matrix[0].length][matrix.length];
        int[] lucky = new int[matrix[0].length];
        int index = 0;
        
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                transposeMatrix[i][j] = matrix[j][i];
            }
            
            lucky[i] = Arrays.stream(transposeMatrix[i]).max().getAsInt();
        }
        
        for(int i = 0; i < matrix.length; i++) {
            int min = Arrays.stream(matrix[i]).min().getAsInt();
            
            for(int j = 0; j < matrix[i].length; j++) {
                if(min == matrix[i][j] && lucky[j] == matrix[i][j]) {
                    result.add(matrix[i][j]);
                }
            }
        }
        
        return result;
    }
}