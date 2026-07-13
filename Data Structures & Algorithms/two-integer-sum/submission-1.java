// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int [] ans = new int[2];
//         Map<Integer, Integer> map = new HashMap<>();
//         // for(int i = 0; i < nums.length; i++){
//         //     map.put(nums[i], i);
//         // }
//         for(int i = 0; i < nums.length; i++){
//             if(map.containsKey(target - nums[i])){
//                 ans[0] = map.get(target - nums[i]);
//                 ans[1] = i;
//                 return ans;
//             }
//             map.put(nums[i], i);
//         }
//         return ans;
//     }
// }
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                // complement index is from map, current index is i
                return new int[] { map.get(complement), i };
            }
            
            // store current value and its index
            map.put(nums[i], i);
        }
        
        // Problem guarantees exactly one solution, but we need a return
        return new int[] {-1, -1}; // or throw exception in real code
    }
}
