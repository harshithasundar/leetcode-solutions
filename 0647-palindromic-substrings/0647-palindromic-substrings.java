class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            //odd length palindrome
            count += expandAroundCentre(s,i,i);
            //even length palindrome
            count+= expandAroundCentre(s,i,i+1);
        }
        return count;
    }

    private int expandAroundCentre(String s, int left, int right){
        int count=0;
        while(left >=0 && right < s.length() && s.charAt(left)== s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}