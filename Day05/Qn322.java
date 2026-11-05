class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];

        // Initialize with an impossible value
        Arrays.fill(dp, amount + 1);

        // Base case
        dp[0] = 0;

        // Calculate minimum coins for each amount
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (i >= coin) {

                    dp[i] = Math.min(
                        dp[i],
                        dp[i - coin] + 1
                    );
                }
            }
        }

        // Check whether amount can be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}