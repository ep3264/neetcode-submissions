class Solution {
    public int findMin(int[] nums) {
               if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        boolean larger = false;
        while (left <= right) {
            int mid = (int) Math.ceil(left + (right - left) / 2);
            if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
                return larger ? nums[right + 1] : nums[left];
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
                larger = true;
            } else {
                left = mid + 1;
                larger = false;
            }
        }

       throw new RuntimeException();
    }
}
