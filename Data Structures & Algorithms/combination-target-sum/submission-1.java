class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result, 0, new ArrayList<>(), nums, target);

        return result;
    }

    public void combinationSum(List<List<Integer>> result, int start, List<Integer> current, int[] nums, int target) {

        if (target < 0) return;

        if (target == 0)
            result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);

            combinationSum(result, i, current, nums, target - nums[i]);

            current.remove(current.size() - 1);

        }

    }
}
