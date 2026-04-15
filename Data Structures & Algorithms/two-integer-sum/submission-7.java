class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var diff = target - nums[i];

            var cur = map.get(diff);
            if (cur != null) {
                return new int[]{cur, i};
            } else {
                map.putIfAbsent(nums[i], i);
            }
        }

        throw new RuntimeException();
    }
}
