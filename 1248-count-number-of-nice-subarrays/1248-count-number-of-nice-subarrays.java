class Solution {
    public int countAtmost(int[] nums, int k) {
        int left=0 , res=0;

        for(int right=0;right<nums.length;right++){
            //if curr num is odd, reduce k
            if(nums[right]%2==1){
                k--;
            }
            //shrink the window until k is valid
            while(k<0){
                if(nums[left]% 2!=0){
                    k++;
                
                }
                left++;
            }
            res += (right-left+1);
        }
        return res;
    }
    public int numberOfSubarrays(int[] nums,int k){
        return countAtmost(nums,k) - countAtmost(nums,k-1); 
    }
}