class Solution {
    public int findKthLargest(int[] nums, int k) {
        //brute force is to sort the entire array, and take nums[n-k]: o(nlogn)
        //better soln is to use min heap
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int num:nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}