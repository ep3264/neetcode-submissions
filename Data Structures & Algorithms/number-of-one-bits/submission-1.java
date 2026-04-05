class Solution {
    public int hammingWeight(int n) {
        int numBits = 0;
        int cur = n;
        while (cur != 0) {

            cur &= cur - 1;
            numBits++;
        }

        return  numBits;
    }
}
