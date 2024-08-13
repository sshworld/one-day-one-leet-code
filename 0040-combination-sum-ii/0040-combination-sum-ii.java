class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        
        if (Arrays.stream(candidates).sum() == target) {
            result.add(Arrays.stream(candidates).boxed().collect(Collectors.toList()));
            return new ArrayList<>(result);
        }
        
        if (Arrays.stream(candidates).sum() < target) {
            return new ArrayList<>();
        }
        
        Arrays.sort(candidates);
        dfs(candidates, target, result, 0, new ArrayList<Integer>());
        
        return new ArrayList<>(result);
    }
    
    private void dfs(int[] candidates, int target, Set<List<Integer>> result, int index, List<Integer> numbers) {
        if (target == numbers.stream().mapToInt(Integer::intValue).sum()) {
            result.add(new ArrayList<>(numbers));
            return;
        }
        
        if (numbers.stream().mapToInt(Integer::intValue).sum() > target) {
            return;
        }
        
        if (index > candidates.length) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            numbers.add(candidates[i]);
            dfs(candidates, target, result, i + 1, numbers);
            numbers.remove(numbers.size() - 1);
        }
        
        return;
    }
}