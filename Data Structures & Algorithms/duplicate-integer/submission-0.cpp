class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        std::unordered_set<int> set;
        for (auto it = nums.cbegin(); it != nums.cend(); ++it)
        {
            if (set.find(*it) != set.end())
            {
                return true;
            }
            set.insert(*it);
        }

        return false;
    }
};