class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(numbers.containsKey(nums[i])) {
                numbers.put(nums[i], numbers.get(nums[i]) + 1);
            } else {
                numbers.put(nums[i], 0);
            }
            
            result.add(nums[i]);
        }
        
        Collections.sort(result, (a, b) -> 
            numbers.get(a) == numbers.get(b) ? b - a : numbers.get(a) - numbers.get(b)
        );
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}