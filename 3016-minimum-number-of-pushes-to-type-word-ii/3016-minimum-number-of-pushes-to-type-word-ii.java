class Solution {
    public int minimumPushes(String word) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        int count = 0;
        int push = 1;
        
        for(String str : word.split("")) {
            map.putIfAbsent(str, 0);
            map.put(str, map.get(str) + 1);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        for(String key : keySet) {
            if(count == 8) {
                push++;
                count = 0;
            }
            result += (map.get(key) * push);
            count++;
        }
        
        return result;
    }
}