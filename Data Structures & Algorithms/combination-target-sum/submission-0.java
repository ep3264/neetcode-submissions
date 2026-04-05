class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result, 0, new ArrayList<>(), nums, target);

        return result;
    }

    public void combinationSum(List<List<Integer>> result, int start, List<Integer> current, int[] nums, int target) {
        var sum = current.stream().mapToInt(Integer::intValue).sum();
        if (sum > target) return;

        if (sum == target)
            result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);

            combinationSum(result, i, current, nums, target);

            current.remove(current.size() - 1);

        }

    }
}
