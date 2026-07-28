class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new ArrayDeque<>(); //index 0 -> freq index 1 -> time till could be added back to heap
        for(int i : freq){
            if(i > 0){
                maxHeap.offer(i);
            }
        }
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;

            if(maxHeap.size() > 0){
                int frequency = maxHeap.poll() - 1;
                if(frequency > 0){
                    queue.offer(new int [] {frequency, time + n});
                }
            }
            
            if(queue.size() > 0 && queue.peek()[1] <= time){
                int num = queue.poll()[0];
                maxHeap.offer(num);
            }

        }
        return time;
    }
}
