class Solution {
    public int sumDecoded(long[] nums) {
        long MOD = 1000000007;
        long ans = 0;

        for (long num : nums) {

            int width = (int)(num % 10);
            long d = num / 10;

            String s = String.valueOf(d);

            long x = Long.parseLong(s.substring(0, width));
            long y = Long.parseLong(s.substring(width));

            long value = 1;

            // Calculate x^y
            while (y > 0) {
                if (y % 2 == 1) {
                    value = (value * x) % MOD;
                }

                x = (x * x) % MOD;
                y /= 2;
            }

            ans = (ans + value) % MOD;
        }
        return (int)ans;
    }
}