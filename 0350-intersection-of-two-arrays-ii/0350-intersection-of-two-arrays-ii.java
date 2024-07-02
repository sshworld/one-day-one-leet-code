class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] temp = new int[1001];
        int[] result = new int[1001];
        int count = 0;
        
        for (int num : nums1) {
            temp[num]++;
        }
        
        for (int num : nums2) {
            if (temp[num] > 0) {
                result[count++] = num;
                temp[num]--;
            }
        }
        
        return Arrays.copyOfRange(result, 0, count);
    }
}