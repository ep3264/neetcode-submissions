class Solution {
    public boolean hasDuplicate(int[] nums) {
        var set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) {
                return  true;

            }
            set.add(n);
        }
        return  false;
    }
}