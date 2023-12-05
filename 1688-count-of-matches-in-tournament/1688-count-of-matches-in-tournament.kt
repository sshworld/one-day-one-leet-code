class Solution {
    fun numberOfMatches(n: Int): Int {
        var answer = 0
        var teams = n
        
        while(teams != 1) {
            if (teams % 2 == 0) {
                answer += matchEven(teams)
                teams = teams / 2
            } else {
                answer += matchOdd(teams)
                teams = teams / 2 + 1
            }
        }
        
        return answer
    }
    
    private fun matchOdd(teams: Int): Int {
        return (teams - 1) / 2
    }
    
    private fun matchEven(teams: Int): Int {
        return teams / 2
    }
}