class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        unordered_set<int> s;
        for (int i = 0; i < nums.size() - 1; i++)
        {
            if (s.find(nums[i]) != s.end())
            {
                continue;
            }
            s.insert(nums[i]);
            for (int j = i + 1; j < nums.size(); j++)
            {
                if (nums[i] + nums[j] == target)
                    return vector<int>({i, j});
            }
        }
        return result;
    }
};
