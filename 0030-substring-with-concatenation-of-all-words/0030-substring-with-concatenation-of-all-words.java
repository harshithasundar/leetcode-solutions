class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordLength=words[0].length();
        int wordCount=words.length;

        //what words do we need?
        HashMap<String,Integer> need = new HashMap<>();
        for(String word: words){
            need.put(word,need.getOrDefault(word,0)+1);
        }
        //try every possible allignment
        for(int offset=0;offset<wordLength;offset++){
            int left=offset;
            int right=offset;

            HashMap<String,Integer>window=new HashMap<>();
            int count=0;
            while(right + wordLength <= s.length()){
                String word =s.substring(right,right+wordLength);
                right += wordLength;

                //word is not required
                if(!need.containsKey(word)){
                    window.clear();
                    count=0;
                    left=right;
                    continue;
                }
                //add word to window
                window.put(word,window.getOrDefault(word,0)+1);
                count++;
                 // Too many copies of this word
                while (window.get(word) > need.get(word)) {

                    String leftWord =
                        s.substring(left, left + wordLength);

                    window.put(
                        leftWord,
                        window.get(leftWord) - 1
                    );

                    left += wordLength;
                    count--;
                }

                // We have exactly all required words
                if (count == wordCount) {
                    result.add(left);

                    // Move left forward to look for next window
                    String leftWord =
                        s.substring(left, left + wordLength);

                    window.put(
                        leftWord,
                        window.get(leftWord) - 1
                    );

                    left += wordLength;
                    count--;
                }
            }
        }

            
        return result;
    }
}