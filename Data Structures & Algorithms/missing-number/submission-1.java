class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int expected = (n * (n + 1)) / 2;
        int ret = expected - Arrays.stream(nums).sum();

        return ret;
    }
}
