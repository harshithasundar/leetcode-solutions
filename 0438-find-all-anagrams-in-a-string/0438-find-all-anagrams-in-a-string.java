class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        //edge case
        if(s.length()<p.length()){
            return result;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for(char c : p.toCharArray()){
            need[c-'a']++;
        }
        int k =p.length();

        for(int right=0;right<s.length();right++){
            //add char
            window[s.charAt(right)- 'a']++;
            //remove char if window size became large
            if(right>=k){
                window[s.charAt(right - k)-'a']--;
            }
            //check window
            if(right >= k-1){
                if( Arrays.equals(need,window)){
                    result.add(right-k+1);
                }
                
            }
        }
        return result;
    }
}