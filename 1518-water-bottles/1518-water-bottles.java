class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = 0;
        int emptyBottle = 0;
        
        while(numBottles != 0) {
            result += numBottles;
            emptyBottle += numBottles;
            
            numBottles = emptyBottle / numExchange;
            emptyBottle %= numExchange;
        }
        
        return result;
    }
}