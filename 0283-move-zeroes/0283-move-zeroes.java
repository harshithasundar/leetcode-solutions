class Solution {
    public void moveZeroes(int[] nums) {
        //two pointers(in place)
        //i->scans , write->where shud i put next non zero
        int write=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[write];
                nums[write]=temp;

                write++;
            }
        }
    }
}