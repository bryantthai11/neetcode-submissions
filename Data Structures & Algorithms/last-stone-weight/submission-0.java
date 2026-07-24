class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            int diff = Math.abs(x - y);
            if(diff == 0) continue;
            maxHeap.offer(diff);
        }
        if(maxHeap.size() == 1){
            return maxHeap.poll();
        }else{
            return 0;
        }
    }
}
