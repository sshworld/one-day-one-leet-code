class Solution {
    public String fractionAddition(String expression) {
        String[] nums = expression.split("(?=[+-])");
        int[] result = new int[]{ 0, 1 };
        
        for (String num : nums) {
            result = add(result, toArray(num));
        }
        
        return result[0] + "/" + result[1];
    }
    
    private int[] add(int[] a, int[] b) {
        int c = a[0] * b[1] + a[1] * b[0], d = a[1] * b[1], gcd = gcd(Math.abs(c), Math.abs(d));
        return new int[]{c / gcd, d / gcd};
    }
    
    private int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (a == 0 || b == 0) return a + b;
        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
    private int[] toArray(String s) {
        return Stream.of(s.split("/")).mapToInt(Integer::parseInt).toArray();
    }
}

// a/A + b/B

// ad + cb
// b*d