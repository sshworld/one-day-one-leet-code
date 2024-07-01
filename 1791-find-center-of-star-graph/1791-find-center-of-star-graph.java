class Solution {
    public int findCenter(int[][] edges) {
        int totalNodeCount = edges.length + 2;
        int max = 0;
        int maxIndex = 0;
        
        int[] nodeCounts = new int[totalNodeCount];
        
        for (int i = 0; i < edges.length; i++) {
            nodeCounts[edges[i][0]] += 1;
            nodeCounts[edges[i][1]] += 1;
        }
        
        for (int i = 0; i < nodeCounts.length; i++) {
            if (nodeCounts[i] > max) {
                max = nodeCounts[i];
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
}