class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r]) return nums[l];

        while (l < r) {
            int m = (int) Math.ceil(l + (r - l) / 2.0);

            if (nums[m] < nums[l]) {
                for (int i = m; i > l; i--) {
                    if (nums[i] <= nums[i - 1])  return nums[i];
                }
            } else {
                l = m;
            }
        }

        return nums[l];
    }
}
