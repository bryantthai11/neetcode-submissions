class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        if(s.length() == 0){
            return 0;
        }
        charSet.add(s.charAt(left));
        int maxLen = charSet.size();
        for(int i = 1; i < s.length(); i ++){
            char ch = s.charAt(i);
            while(charSet.contains(ch) && left < i){
                char removeChar = s.charAt(left);
                charSet.remove(removeChar);
                left++;
            }
            charSet.add(ch);
            maxLen = Math.max(maxLen, charSet.size());
        }
        return maxLen;
    }
}
