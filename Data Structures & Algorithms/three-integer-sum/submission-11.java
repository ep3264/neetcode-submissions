class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        System.out.println(Arrays.toString(nums));
        for (var i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            var cur = nums[i];
            var left = i + 1;
            var right = nums.length - 1;

            while (left < right) {
                var sum = cur + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(cur, nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (sum < 0) left++;
                else right--;
            }

        }

        return result;
    }

    
}
