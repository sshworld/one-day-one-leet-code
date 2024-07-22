class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> people = new HashMap<>();
        String[] result = new String[names.length];
        
        for(int i = 0; i < names.length; i++) {
            people.put(heights[i], names[i]);
        }
        
        Arrays.sort(heights);
        
        for(int i = heights.length - 1; i >= 0; i--) {
            result[heights.length -1 - i] = people.get(heights[i]);
        }
        
        return result;
    }
}