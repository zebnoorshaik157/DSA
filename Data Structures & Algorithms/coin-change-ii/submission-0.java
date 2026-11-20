class Solution {

    public int solve(int i, int[] coins, int amount, int[][] dp) {

        // Base case: Amount completed
        if (amount == 0) {
            return 1;
        }

        // No coins left
        if (i == coins.length) {
            return 0;
        }

        // Already calculated
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        // If current coin is greater than amount, skip it
        if (coins[i] > amount) {
            return dp[i][amount] =
                solve(i + 1, coins, amount, dp);
        }

        // TAKE: Use the same coin again
        int take = solve(i, coins, amount - coins[i], dp);

        // SKIP: Move to the next coin
        int skip = solve(i + 1, coins, amount, dp);

        return dp[i][amount] = take + skip;
    }

    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, coins, amount, dp);
    }
}
