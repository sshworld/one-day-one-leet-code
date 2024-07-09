class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time = 0;
        int[] timeTable = new int[customers.length];
        
        for(int i = 0; i < customers.length; i++) {
            int[] customer = customers[i];
            
            if (time <= customer[0]) {
                time = customer[0];
            }
            
            timeTable[i] = time + customer[1] - customer[0];
            time += customer[1];
        }
        
        return Arrays.stream(timeTable).average().orElse(0.0);
    }
}