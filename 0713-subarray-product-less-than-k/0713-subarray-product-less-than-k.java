class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //edge case: k<=1
        if(k<=1){
            return 0;
        }

        //sliding window
        int left=0;
        int answer = 0;
        long product =1;

        for(int right=0;right<nums.length;right++){
            product*=nums[right];
            while(product>=k){
                product /= nums[left];
                left++;
            }
            answer+= right-left+1;
        }
        return answer;
    }
}