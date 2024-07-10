class Solution {
    public int minOperations(String[] logs) {
        int result = 0;
        
        for(String log : logs) {
            if(log.equals("./")) {
                result += 0;
                continue;
            }
            
            if(log.equals("../")) {
               if(result > 0) {
                   result -= 1;
               }
                continue;
            }
            
            result += 1;
        }
        
        return result;
    }
}