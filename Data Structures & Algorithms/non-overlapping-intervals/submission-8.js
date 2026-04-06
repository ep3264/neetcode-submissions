class Solution {
    /**
     * @param {number[][]} intervals
     * @return {number}
     */
    eraseOverlapIntervals(intervals) {
        if (intervals.length <= 1) return 0;

        intervals.sort((a, b) => {
            let ret = a[0] - b[0];
            if (ret == 0) return b[1] - a[1];
            return ret;
        }
        );
        let counter = 0;

        for (let i = 0, j = 1; i < intervals.length - 1 && j < intervals.length; i++, j++) {



            if (intervals[i][1] <= intervals[j][0]) {
                continue;
            }
            if (intervals[i][0] === intervals[j][0]) {
                counter++;
                continue;
            }
            if (intervals[i][1] > intervals[j][1]) {
                counter++
                continue;
            }

            for (; j < intervals.length && intervals[i][1] > intervals[j][0] && intervals[i][1] <= intervals[j][1];
                j++, counter++);

            if (j < intervals.length && intervals[i][1] > intervals[j][1]) counter++;

            i = j - 1;
        }

        return counter;
    }
}
