class Solution {
    public int climbStairs(int n) {
        // //ways(n)=ways(n-1)+ways(n-2) resembles fibonacci
        // //brute
        // if(n==1){
        //     return 1;
        // }
        // if(n==2){
        //     return 2;
        // }
        // return climbStairs(n-1) + climbStairs(n-2);

        //dp
        // int[] dp = new int[n+1];

        // dp[1]=1;
        // dp[2]=2;

        // for(int i=3;i<=n;i++){
        //     dp[i]= dp[i-1] + dp[i-2];
        // }
        // return dp[n];

        //optimal
        if(n==1){
            return 1;
        }
        int prev2=1;
        int prev1=2;

        for(int i=3; i<=n;i++){
            int current = prev1+prev2;

            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}