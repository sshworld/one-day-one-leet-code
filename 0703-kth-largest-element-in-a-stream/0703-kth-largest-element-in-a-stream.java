import java.util.stream.Collectors;

class KthLargest {
    
    private final int index;
    private final List<Integer> numbers;

    public KthLargest(int k, int[] nums) {
        index = k;
        numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
    
    public int add(int val) {
        numbers.add(val);
        Collections.sort(numbers, Collections.reverseOrder());
        
        return numbers.get(index - 1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */