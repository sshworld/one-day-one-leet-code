class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int result = 0;
        int[] numbers = new int[n * (n + 1) / 2];
        int index = 0;
        int mod = 1000000007;
        
        for(int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            numbers[index++] = sum;
            
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                numbers[index++] = sum;
            }
        }
        
        Arrays.sort(numbers);
        
        for(int i = left - 1; i < right; i++) {
            result = (result + numbers[i]) % mod;
        }
        
        return result;
    }
}