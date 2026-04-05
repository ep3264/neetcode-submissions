class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    threeSum(nums) {
        // we can sort
        // then use two pointer to find 3 suitable elements


        nums.sort((a, b) => a - b);
        const set = new Set();

        const ret = [];
        for (let i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            let left = i + 1, right = nums.length - 1;
            while (left < right) {

                const p = [nums[i], nums[left], nums[right]];
                const sum = nums[i] + nums[left] + nums[right];
                if (sum === 0 && !set.has(p.join(','))) {
                    ret.push(p);
                    set.add(p.join(','));
                }

                else if (sum < 0) { left++; continue; }
                right--;

            }
        }


        return ret;
    }
}
