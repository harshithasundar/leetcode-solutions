class Solution {
    public int[] sortedSquares(int[] nums) {
        // for(int i=0;i<nums.length;i++){
        //     nums[i]=nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

        //two pointers
        int n = nums.length;
        int[] answer = new int[n];

        int left=0;
        int right=n-1;
        int pos=n-1;

        while(left<=right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];

            if(leftSquare > rightSquare){
                answer[pos]=leftSquare;
                left++;
            }
            else{
                answer[pos]=rightSquare;
                right--;
            }
            pos--;
        }
        return answer;
    }
}