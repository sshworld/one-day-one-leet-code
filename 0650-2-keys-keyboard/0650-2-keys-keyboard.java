class Solution {
    public int minSteps(int n) {
        return dfs(n, 0, 0, 1);
    }
    
    private int dfs(int n, int clipboard, int count, int notepad) {
        if (notepad == n) {
            return count;
        }
        
        if (notepad > n || clipboard > n) {
            return Integer.MAX_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        
        if (clipboard != notepad) {
            min = Math.min(min, dfs(n, notepad, count + 1, notepad));
        }
        
        if (notepad != notepad + clipboard) {
            min = Math.min(min, dfs(n, clipboard, count + 1, notepad + clipboard));
        }
        
        return min;
    }
}