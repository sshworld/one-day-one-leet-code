class Solution {
    public String nearestPalindromic(String n) {
        int left = (n.length() + 1) / 2;
        int right = n.length() - left;
        long head = Long.parseLong(n.substring(0, left));
        long origin = Long.parseLong(n);
        long diff = Long.MAX_VALUE;
        long num = 0;
        
        for (int i = -1; i <= 1; i++) {
            long ret = getPalindrome(head + i, right);
            if (ret != origin && Math.abs(ret - origin) < diff) {
                diff = Math.abs(ret - origin);
                num = ret;
            }
        }
        
        return Long.toString(num);
    }
    
    private long getPalindrome(long head, int rightLength) {
        String str = Long.toString(head);
        StringBuilder sb = new StringBuilder(str);
        
        if (head == 0l || rightLength > str.length()) {
            for (int i = 0; i < rightLength; i++) {
                sb.append('9');
            }
        } else {
            for (int i = rightLength - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
        }
        
        return Long.parseLong(sb.toString());
    } 
}