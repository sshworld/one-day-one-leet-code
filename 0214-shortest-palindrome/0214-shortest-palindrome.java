class Solution {
    public String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int end = chars.length - 1;
        
        for (; end>= 0; end--) {
          if (isPalin(chars, 0, end)) {
            break;
          }
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = chars.length - 1; i > end; i--) {
          sb.append(chars[i]);
        }
        
        sb.append(chars);

        return sb.toString();
    }
    
    private boolean isPalin(char[] chars, int start, int end) {
        while (start < end) {
          Character l = chars[start];
          Character r = chars[end];

          if (l != r) {
            return false;
          }

          start++;
          end--;
        }

        return true;
  }
}