class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        int result = 0;
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        char c1 = x > y ? 'a' : 'b';
        char c2 = x > y ? 'b' : 'a';
        
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c1 && c == c2) {
                stack.pop();
                result += max;
                continue;
            }
            
            stack.push(c);
        }
        
        while(!stack.isEmpty()) {
            char c = stack.pop();
            
            if(!temp.isEmpty() && temp.peek() == c1 && c == c2) {
                temp.pop();
                result += min;
                continue;
            }
            
            temp.push(c);
        }
        
        return result;
    }
}