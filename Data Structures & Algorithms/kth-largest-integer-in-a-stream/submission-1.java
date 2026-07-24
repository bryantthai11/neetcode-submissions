class KthLargest {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    int k;
    public KthLargest(int k, int[] nums) {
        for(int num : nums){
            maxHeap.offer(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
        maxHeap.offer(val);
        PriorityQueue<Integer> tmp = new PriorityQueue<>(maxHeap);
        for(int i = 0; i < k - 1; i++){//dont have to worry about less than k elements, guarantees in description
            tmp.poll();
        }
        return tmp.peek();
    }
}
