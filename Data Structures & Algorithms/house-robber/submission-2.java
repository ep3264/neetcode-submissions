class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) return nums[0];

        int[] cache = new int[nums.length];

        cache[0] = nums[0];
        cache[1] = Math.max(cache[0], nums[1]);
        int max = cache[1];
        for (int i = 2; i < nums.length; i++) {
            cache[i] = Math.max(cache[i - 2] + nums[i], cache[i - 1]);
            max = cache[i];
        }

        return max;           
    }
}
