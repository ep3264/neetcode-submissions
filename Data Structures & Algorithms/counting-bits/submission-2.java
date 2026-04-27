class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            result[i] = result[i & i - 1] + 1;
        }
        
        return result;
    }
}
