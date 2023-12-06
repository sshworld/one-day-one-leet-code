class Solution {
    fun largestGoodInteger(num: String): String {
        return num.windowed(size = 3)
            .filter { it[0] == it[1] && it[1] == it[2] }
            .maxOrNull() ?: ""
    }
}