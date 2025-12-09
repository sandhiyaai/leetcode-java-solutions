import java.util.Arrays;
class Solution {
    //------------------------------------------------------------
   // 1️. Memoization (Top-Down DP)
  // ------------------------------------------------------------
    public int fibMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n,dp);
    }

    private int helper(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != -1) return dp[n];

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }


    // ------------------------------------------------------------
    // 2️.Tabulation (Bottom-Up DP)
    // ------------------------------------------------------------
    public int fibTab(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    // ------------------------------------------------------------
    // 3️. Space Optimization (2 Variables)
    // ------------------------------------------------------------
    public int fibSpaceOpt(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
