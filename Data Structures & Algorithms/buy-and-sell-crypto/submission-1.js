class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices) {
        let profit = 0;
        let min = prices[0];
        for (const price of prices) {
            profit = Math.max(profit, price - min);
            min = Math.min(min, price);

        }

        return profit;
    }
}
