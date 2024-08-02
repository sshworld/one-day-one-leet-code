class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        int count = 0;
        int onesInWindow = 0;
        int[] nums2 = new int[nums.length * 2];

        for (int num: nums) {
            if (num == 1) {
                ones++;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = nums[i % nums.length];
        }

        for (int i = 0; i < nums2.length; i++) {
            if (i >= ones && nums2[i - ones] == 1) {
                 count--;
            }

            if (nums2[i] == 1) {
                count++;
            }

            onesInWindow = Math.max(count, onesInWindow);
        }
        
        return ones - onesInWindow;
    }
}