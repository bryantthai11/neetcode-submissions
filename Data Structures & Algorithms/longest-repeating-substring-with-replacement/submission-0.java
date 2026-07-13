class Solution {
    public int characterReplacement(String s, int k) {
        // we are utilizing a window, move left to right, can utilize a set to keep distinctino,
        //utilize a hashmap, build a window, be greedy, it should be valid only when the map is of size 1 + k
        //is it good to keep a stack? we would have to find the min frequency of the string,
        //we are able to replace the string up to k times frequency

        int left = 0;
        int longestSubstring = 0;
        int largestChar = 0;
        HashMap<Character, Integer> charFrequency = new HashMap<>(); 
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
            largestChar = Math.max(largestChar, charFrequency.get(ch));
            //now we need to have a validity check how should we do this? we know that there are up to k distinct char values we can replace in order to make the string valid,
            //what is the best way to get the other values,
            //Can we get the values, in a sorted array, then compare the total values from index 1 to the end, skipping the 0 index as it is our largest, and seeing if it is less than k?
            //if k + largest char frequency >= length of subarray we have a valid subarray
            //therefore by induction, we do k + largest char frequency < length of subarray it is invalid
            while((right - left + 1) > k + largestChar){
                //need to fix left
                charFrequency.put(s.charAt(left), charFrequency.getOrDefault(s.charAt(left),0) - 1);
                left++;
            }
            longestSubstring = Math.max(longestSubstring, right - left + 1);
        }
        return longestSubstring;

    }
}
