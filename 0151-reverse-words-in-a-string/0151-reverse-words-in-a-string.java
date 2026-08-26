class Solution {
    public String reverseWords(String s) {
//         Remove leading spaces
// Remove trailing spaces
// Convert multiple spaces between words into a single space
// Reverse the words, not the characters
            String[] words= s.trim().split("\\s+");
            StringBuilder result =new StringBuilder();
            //stringbuilder is better than doing result+=word[i]

            for(int i=words.length -1; i>=0;i--){
                result.append(words[i]);

                if(i!=0){
                    result.append(" ");
                }
            }
            return result.toString();
                }
}