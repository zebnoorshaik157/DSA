
class Solution {

    public int f(int ind, int buy, int[] prices, int n, int[][] dp) {

        // Base case
        if (ind >= n) {
            return 0;
        }

        // Already calculated
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        // We are allowed to buy
        if (buy == 1) {

            int take = -prices[ind] + f(ind + 1, 0, prices, n, dp);

            int notTake = f(ind + 1, 1, prices, n, dp);

            return dp[ind][buy] = Math.max(take, notTake);
        }

        // We already own a stock
        else {

            int sell = prices[ind] + f(ind + 2, 1, prices, n, dp);

            int hold = f(ind + 1, 0, prices, n, dp);

            return dp[ind][buy] = Math.max(sell, hold);
        }
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(0, 1, prices, n, dp);
    }
}
