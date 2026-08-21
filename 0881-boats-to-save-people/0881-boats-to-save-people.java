class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //sort the arr
        Arrays.sort(people);

        //have 2 pointers
        int left=0;
        int right= people.length-1;
        int boats=0;

        while(left <=right){
            //try to put lightest and heavest tog first
            if(people[left] + people[right] <= limit){
                left++;
            }
            //heaviest perosn is def assigned a boat
            right--;
            boats++;
        }
        return boats;

    }
}