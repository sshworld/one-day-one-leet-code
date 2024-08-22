class Solution {
    public int findComplement(int num) {
        return ((Integer.highestOneBit(num) << 1) - 1) ^ num;
    }
}