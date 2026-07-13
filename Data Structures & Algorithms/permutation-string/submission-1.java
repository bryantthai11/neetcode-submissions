class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //we just put s2 in a hashmap, then compare, actually we can not do this because the letters have to be adjacent to each other
        //would we just do sliding window on s2, but s1 into a hashmap, 

        //actually dont put it into a hashmap, instead initialize an array of size 26, we can utilize buckets in order to count for frequency of s1, then do one pass in order to keep track of frequencies
        //then we can utilize a sliding window approach in order to check s2, only start if there is presence maybe we can utilize a set to check, then we decrement or increment our array.
        //is this a possible way to solve this problem, this was just my brain dumb for now in 10 ish minutes of this problem, which is not ideal but give me a standard
        if(s1.length() > s2.length()){
            return false;
        }
        int left = 0;
        int[] need = new int[26];
        int[] curr = new int[26];
        for(int i = 0; i < s1.length(); i++){
            need[s1.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s2.length(); i++){
            curr[s2.charAt(i) - 'a']++;
            if(i > s1.length() - 1){
                curr[s2.charAt(left) - 'a'] --;
                left++;
            }
            if(i >= s1.length() - 1 && Arrays.equals(need, curr)){
                return true;
            }
        }
        return false;
    }
}
