class Solution {
    public int minOperations(int[] nums, int sum) {
        int INF = 1000000000;

        int[] dp = new int[sum + 1];

        for (int i = 1; i <= sum; i++) {
            dp[i] = INF;
        }

        for (int x : nums) {

            // Don't use this element
            int[] next = dp.clone();

            // Multiplication possibilities
            int value = x;
            int cost = 0;

            while (value <= sum) {

                for (int s = 0; s + value <= sum; s++) {
                    if (dp[s] != INF) {
                        next[s + value] =
                            Math.min(next[s + value],
                                     dp[s] + cost);
                    }
                }

                value *= 2;
                cost++;
            }

            // Division possibilities
            value = x;
            cost = 0;

            while (value > 1) {

                value /= 2;
                cost++;

                for (int s = 0; s + value <= sum; s++) {
                    if (dp[s] != INF) {
                        next[s + value] =
                            Math.min(next[s + value],
                                     dp[s] + cost);
                    }
                }
            }

            dp = next;
        }

        return dp[sum] == INF ? -1 : dp[sum];
    }
}