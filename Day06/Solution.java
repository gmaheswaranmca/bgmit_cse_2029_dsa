class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // Step 1: Create DP array
        int[] dp = new int[n];

        // Step 2: Initialize every position with 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Step 3: Find increasing subsequences
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // Check whether previous element is smaller
                if (nums[j] < nums[i]) {

                    // Keep the maximum possible length
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Step 4: Find the maximum value in DP array
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}