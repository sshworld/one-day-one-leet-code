class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> parentheses = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (String str : s.split("")) {
            if (str.equals("(")) {
                parentheses.push(sb);
                sb = new StringBuilder();
            } else if (str.equals(")")) {
                String temp = sb.reverse().toString();
                sb = parentheses.pop();
                sb.append(temp);
            } else {
                sb.append(str);
            }
        }
        
        return sb.toString();
    }
}