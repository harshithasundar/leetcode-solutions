class Solution {
    public int splitArray(int[] nums, int k) {
        long low =0;
        long high =0;

        //finding search boundaries
        for(int num:nums){
            low = Math.max(low, num);
            high+= num;
        }

        //bin search
        while(low<high){
            long mid = (low+high)/2;
            if(canSplit(nums,k,mid)){
                high=mid;  //try smaller
            }
            else{
                low= mid +1; //need larger limit
            }
        }
        return (int)low;
    }

    private boolean canSplit(int[] nums,int k, long maxSum){
        int groups=1;
        long currentSum=0;

        for(int num:nums){
            if(currentSum + num>maxSum){
                groups++;
                currentSum =num;
            }
            else{
                currentSum+=num;

            }
            if (groups > k) {
                return false;
            }
        }
        return true;
    }
}