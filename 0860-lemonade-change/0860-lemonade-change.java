class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change5 = 0;
        int change10 = 0;
        int change20 = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                change5 += 1;
            }
            
            if (bill == 10) {
                change10 += 1;
                change5 -= 1;
                
                if (change5 < 0) {
                    return false;
                }
            }
            
            if (bill == 20) {
                change20 += 1;
                
                if (change10 > 0) {
                    change10 -= 1;
                    change5 -= 1;
                } else {
                    change5 -= 3;
                }
                
                if (change5 < 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
}