class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        var freq = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            freq.merge(nums[i], 1, Integer::sum);
        }

        List<Integer>[] keyByFreq = new List[nums.length + 1];
        for (var entry : freq.entrySet()) {
            if (keyByFreq[entry.getValue()] == null)
                keyByFreq[entry.getValue()] = new ArrayList<>();

            keyByFreq[entry.getValue()].add(entry.getKey());
        }

        var result = new int[k];
        int j = 0;
        for (int i = keyByFreq.length - 1; i >= 0; i--) {
            var keys = keyByFreq[i];
            if (keys == null) continue;
            for (int key : keys) {
                result[j++] = key;
                if (j >= k) return result;
            }
        }

        return result;
    }
}
