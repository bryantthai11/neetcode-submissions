class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //you want the max at each window at a time,
        //if we do a max heap, to keep the biggest element 
        //min heap, 
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            heap.offer(new int[] {nums[i], i});
            if(i >= k - 1){
                while(heap.peek()[1] <= i - k){
                    heap.poll();
                }
                output[idx] = heap.peek()[0];
                idx++;            
            }
            
        }
        return output;

    }
     
}
