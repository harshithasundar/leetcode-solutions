class Solution {
    public String largestNumber(int[] nums) {
        //brute force give O(n!) so no 
        //input is int but we need concatenation so string[]
        String[] arr = new String[nums.length];

        //int to str
        for(int i =0; i<nums.length;i++){
            arr[i]= String.valueOf(nums[i]);
        }

        //custom sorting
        //2 strings being compared : "34" & "3", "3" and "34"
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        //if largest number is 0
        if(arr[0].equals("0")){
            return "0";
        }
        //building the answer with string builde
        StringBuilder result = new StringBuilder();
        for(String s:arr){
            result.append(s);
        }
        return result.toString();
    }
}