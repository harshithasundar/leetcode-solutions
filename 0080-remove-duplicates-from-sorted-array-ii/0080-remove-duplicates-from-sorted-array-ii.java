class Solution {
    public int removeDuplicates(int[] nums) {
        //we are allowed to keep both if no. of elem are 1 or 2
        if(nums.length <=2){
            return nums.length;
        }
        int i=2; //slow/write pointer
        for(int j=2;j<nums.length;j++){  //fast/scaning pointer
            if(nums[j] != nums[i-2]){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}