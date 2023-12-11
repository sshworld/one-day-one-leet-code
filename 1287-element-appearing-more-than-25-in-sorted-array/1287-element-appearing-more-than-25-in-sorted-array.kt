class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        return arr.find { n -> arr.count { it == n } > arr.size / 4 } ?: throw IllegalArgumentException()
    }
}