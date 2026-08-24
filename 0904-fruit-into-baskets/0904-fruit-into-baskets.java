class Solution {
    public int totalFruit(int[] fruits) {
        //find longest contig subarray containing at most 2 distinct values
        HashMap<Integer, Integer> map =new HashMap<>();

        int left=0;
        int max=0;
        for(int right=0;right<fruits.length;right++){
            //add fruits to window
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);

            //more than 2 fruits type
            while(map.size() > 2){
                int fruit = fruits[left];

                map.put(fruit, map.get(fruit)-1);

                if(map.get(fruit)==0){
                    map.remove(fruit);
                }
                left++;
            }
            //curr window is valid
            max= Math.max(max,right-left+1);
        }
        return max;
    }
}