class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int [] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = Math.max(sums[i - 1] + nums[i], nums[i]);
        }
        int max = sums[0];
        for (int i = 1; i < sums.length; i++) {
            max = Math.max(max, sums[i]);
        }


        return max;
    }
}
