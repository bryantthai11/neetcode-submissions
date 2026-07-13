class Solution {
    public int longestConsecutive(int[] nums) {
     //naive solution
     Set<Integer> numSet = new HashSet<>();
     for(int num : nums){
        numSet.add(num);
     }
     int ans = 0;
     for(int num : numSet){
        if(!numSet.contains(num - 1)){
            int len = 1;
            int curr = num;
            while(numSet.contains(curr + len)){
                len++;
            }
            ans = Math.max(ans, len);
        }
     }
     return ans;
    }
}
