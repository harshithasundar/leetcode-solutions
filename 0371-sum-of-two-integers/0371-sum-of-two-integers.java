class Solution {
    public int getSum(int a, int b) {
        while(b!=0){ //keep calculating while there is still a carry
            int sum=a^b; //xor perfomrns addition wo considering carry
            int carry =(a&b)<<1;
            a=sum;
            b=carry;
        }
        return a;
    }
}