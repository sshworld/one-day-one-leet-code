class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[1690];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        
        for (int i = 1; i < n; i++) {
            int num = Math.min(Math.min(ugly[index2] * 2, ugly[index3] * 3), ugly[index5] * 5);
            
            if (num == ugly[index2] * 2) index2++;
            if (num == ugly[index3] * 3) index3++;
            if (num == ugly[index5] * 5) index5++;
            
            ugly[i] = num;
        }
        
        return ugly[n - 1];
    }
}