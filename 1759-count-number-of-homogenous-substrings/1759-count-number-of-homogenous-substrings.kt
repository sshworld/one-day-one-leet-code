class Solution {
    fun countHomogenous(s: String): Int {
        val mod = 1_000_000_007
        var answer = 0
        var count = 1
        var previousChar = '.'
        
        for (c in s) {
            if (c == previousChar) count++
            else count = 1
            
            answer = (answer + count) % mod
            previousChar = c
        }
        
        return answer
    }
}