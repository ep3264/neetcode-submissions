class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int diff =  target - nums[i];
            Integer index = null;
            if ((index = map.get(diff)) != null) {
                return  new int[] {index, i};
            }
            map.put(nums[i], i);
        }

        return  new int[] {-1, -1};
    }
}
