class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n- k+1]; //n-k+1 windows

        Deque<Integer> dq = new ArrayDeque<>();//stores only inidces
        int index =0;

        for(int i=0;i<n;i++){
            // remove expired index
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            // remove smaller elements
            while(!dq.isEmpty() && nums[dq.peekLast()]<= nums[i]){
                dq.pollLast();
            }
            //insert current index
            dq.offerLast(i);
            //window completes
            if(i >= k-1){
                ans[index++]= nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}