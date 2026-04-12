class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int result = 0;
        int j = 1;
        for (int i = 0; i < intervals.length - 1 && j < intervals.length; i++, j++) {
            while (j < intervals.length && intervals[i][1] > intervals[j][0]) {
                result++;
                j++;
            }
            i = j - 1;
        }
        return result;
    }
}
