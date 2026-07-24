class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // what if we calculate the distance of the points then map the values of the points to an index in a hashmap where the indexes are stored as a list, bc you can have multiple similar distances
        //then we store the distances in a maxHeap
        //

        Map<Double, List<Integer>> distanceMap = new HashMap<>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < points.length; i ++){
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            distanceMap.computeIfAbsent(distance, key -> new ArrayList<>()).add(i);
            maxHeap.offer(distance);
            if(maxHeap.size() > k){
                double key = maxHeap.poll();
                distanceMap.get(key).remove(distanceMap.get(key).size() - 1);
            }
        }

        int[][] ans = new int[k][2];
        int size = maxHeap.size();
        for(int i = 0; i < size; i++){
            double key = maxHeap.poll();
            int idx = distanceMap.get(key).get((distanceMap.get(key).size() - 1));
            distanceMap.get(key).remove(distanceMap.get(key).size() - 1);
            // int idx = distanceMap.get(key).get(0);
            // distanceMap.get(key).remove(0);
            ans[i][0] = points[idx][0];
            ans[i][1] = points[idx][1];// no need to do collections.reverse order due to it saying its fine
        }
        return ans;


    }
}
