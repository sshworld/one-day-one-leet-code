class Solution {
    int count = 0;
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int minCount = n - 1;
        int result = n - 1;
        
        for(int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        for(int i = n - 1; i >= 0; i--) {
            boolean[] visited = new boolean[n];
            bfs(i, map, visited, distanceThreshold);
            
            if(count < minCount) {
                minCount = count;
                result = i;
            }
            
            count = 0;
        }
        
        return result;
    }
    
    private void bfs(int start, Map<Integer, List<int[]>> map, boolean[] visited, int distance) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {start, 0});
        
        while(!queue.isEmpty()) {
            int[] city = queue.poll();
            int index = city[0];
            int sum = city[1];
            visited[index] = true;
            List<int[]> list = map.getOrDefault(index, new ArrayList<int[]>());
            
            for(int[] item : list) {
                if(!visited[item[0]] && sum + item[1] <= distance) {
                    queue.add(new int[] {item[0], sum + item[1]});
                    count++;
                }
            }
        }
    }
}