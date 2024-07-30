class Solution {
    public int minimumDeletions(String s) {
        int result = 0;
        int balanced = 0;
        
        for(char c : s.toCharArray()) {
            if (c == 'a' && balanced > 0) {
                balanced -= 1;
                result += 1;
            }
            
            if (c == 'b') {
                balanced += 1;
            }
        }
        
        return result;
    }
}