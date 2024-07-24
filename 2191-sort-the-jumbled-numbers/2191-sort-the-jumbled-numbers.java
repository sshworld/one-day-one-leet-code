class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] result = new int[nums.length];
        int[][] mapped = new int[nums.length][2];
        
        for(int i = 0; i < nums.length; i++) {
            mapped[i][0] = nums[i];
            mapped[i][1] = mappedValue(mapping, nums[i]);
        }
        
        Arrays.sort(mapped, (a, b) -> a[1] - b[1]);
        
        for(int i = 0; i < nums.length; i++) {
            result[i] = mapped[i][0];
        }
        
        return result;
    }
    
    private int mappedValue(int[] mapping, int num) {
        int mappedValue = 0;
        String value = Integer.toString(num);
        
        for(String s : value.split("")) {
            mappedValue += mappedValue * 10 + (mapping[Integer.parseInt(s)]);
        }
        
        return mappedValue;
    }
}