class Solution {
    public int numTeams(int[] rating) {
        int result = 0;
        
        for(int i = 1; i < rating.length - 1; i++) {
            int smallLeft = 0, smallRight = 0;
            int bigLeft = 0, bigRight = 0;
            
            for(int j = 0; j < i; j++) {
                if(rating[i] > rating[j]) {
                    smallLeft++;
                } else {
                    bigLeft++;
                }
            }
            
            for(int k = i + 1; k < rating.length; k++) {
                if(rating[k] > rating[i]) {
                    bigRight++;
                } else {
                    smallRight++;
                }
            }
            
            result += (bigLeft * smallRight) + (smallLeft * bigRight);
        }
        
        return result;
    }
}