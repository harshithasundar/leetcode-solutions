class Solution {
    public int[][] merge(int[][] intervals) {
        //edge case
        if(intervals == null || intervals.length <=1){
            return intervals;
        }

        //sort by start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        //init with 1st interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        //single pass to merge overlapping intervals
        for(int[] nextInterval : intervals){
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if(nextStart <= currentEnd){
                //overlap found
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }
            else{
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
