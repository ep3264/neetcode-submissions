class Solution {
    public int maxProfit(int[] prices) {
        var max = 0;
        var min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }
}
