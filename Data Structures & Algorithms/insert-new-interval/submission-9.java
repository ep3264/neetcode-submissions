class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[0][]);
        }

        int i = 0;
        for (; i < intervals.length; i++) {
            var cur = intervals[i];
            if (cur[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(cur);
                break;
            }
            if (cur[0] < newInterval[0] && cur[1] >= newInterval[0] || newInterval[0] <= cur[0]) {
                int start = cur[0];
                if (newInterval[0] <= cur[0]) start = newInterval[0];
                int end = cur[1];
                while (intervals[i][1] < newInterval[1] && i < intervals.length - 1)  i++;

                if (intervals[i][0] > newInterval[1]) i--;
                if (intervals[i][1] > newInterval[1]) end = intervals[i][1];
                else {
                    end = newInterval[1];
                }

                result.add(new int[]{start, end});
                break;


            } else {
                result.add(intervals[i]);
            }
        }
        if (i == intervals.length) {
            result.add(newInterval);
        }

        int j = i + 1;
        while (j < intervals.length) {
            result.add(intervals[j]);
            j++;
        }

        return result.toArray(new int[0][]);
    }
    
}
