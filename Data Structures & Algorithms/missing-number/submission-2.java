class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int ret = n;
        for (int i = 0; i < n; i++) {
            ret ^=  i ^ nums[i];
        }

        return ret;
    }
}
