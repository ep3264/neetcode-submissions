class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        var freq = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

           if (freq.containsKey(nums[i])) {
               int counter = freq.get(nums[i]);
               freq.put(nums[i], counter + 1);
           } else {
               freq.put(nums[i], 1);
           }
         }


        var queue = new PriorityQueue<Map.Entry<Integer,Integer>>(Comparator.comparingInt(Map.Entry::getValue));
        for (var entry : freq.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }

        return queue.stream().mapToInt(e -> e.getKey().intValue()).toArray();
    }
}
