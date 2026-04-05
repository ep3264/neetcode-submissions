class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices) {
    if (!prices.length || prices.length === 1) return 0;
    let ret = 0;
    let max = prices[0];
    let min = prices[0];
    for (let i = 1; i < prices.length; i++) {

        if (prices[i] > max) max = prices[i];

        if (prices[i] < min) {
            let diff = min - prices[i];
            min = prices[i];
            max -= diff;
        }
        if (max === min) continue;
        if (max > prices[i]) continue;

        if (ret < prices[i] - min) {
            ret = prices[i] - min;
        }

    }

    return ret;
    }
}
