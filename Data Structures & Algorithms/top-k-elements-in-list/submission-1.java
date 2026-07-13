class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        List<Integer> [] freqBucket = new List[n + 1];

        for(int i = 0; i <= n; i++){
            freqBucket[i] = new ArrayList<>();
        }

        //now we need to fill the buckets
        // Get the entrySet
        // Set<Map.Entry<String, String>> entrySet = myMap.entrySet();

        // // Iterate over the entrySet using a for-each loop
        // for (Map.Entry<String, String> entry : entrySet) {
        //     String key = entry.getKey();
        //     String value = entry.getValue();
        //     System.out.println("Key: " + key + ", Value: " + value);
        // }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            freqBucket[freq].add(num);
        }

        //now we need to 
        // 4. Collect the top k frequent elements
        int[] result = new int[k];
        int index = 0;

        // Start from the max possible frequency and go down
        for (int freq = n; freq >= 1 && index < k; freq--) {
            for (int num : freqBucket[freq]) {
                result[index++] = num;
                if (index == k) {
                    break;
                }
            }
        }

        return result;
    

    }
}
