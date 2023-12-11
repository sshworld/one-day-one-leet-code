class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        return Array<IntArray>(matrix[0].size) { i ->
            IntArray(matrix.size) { j ->
                matrix[j][i]
            }
        }
    }
}