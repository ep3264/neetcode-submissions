class Solution {
    public int reverseBits(int n) {
        var result = 0;
        int bit = 31;
        while (n != 0) {
            result = result | ((n & 1) << bit);
            n = n >>> 1;
            bit--;
        }
        return result;   
    }
}
