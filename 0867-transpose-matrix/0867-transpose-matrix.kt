class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        return Array<IntArray>(matrix[0].size) { index ->
            IntArray(matrix.size).apply {
                matrix.forEachIndexed { i, num ->
                    this[i] = num[index]
                }
            }
        }
    }
}