class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        //You can solve this problem in linear time by checking if the total sum of the array is divisible by 3 and then finding two partition points
        int totalSum=0;
        for(int num : arr){
            totalSum+= num;
        }

        if(totalSum % 3 !=0){
            return false;
        }
        int target=totalSum/3;
        int runningSum=0;
        int partitions =0;

        for(int num : arr){
            runningSum+=num;
            if(runningSum == target){
                partitions++;
                runningSum=0; //reset for the next part
            }
        }
        return partitions >=3;
    }
}