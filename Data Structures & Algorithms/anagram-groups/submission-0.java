// import java.util.*;

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();

//         for (String s : strs) {
//             // Count frequency of each letter
//             int[] counts = new int[26];
//             for (int i = 0; i < s.length(); i++) {
//                 char c = s.charAt(i);
//                 counts[c - 'a']++;
//             }

//             // Build a key from counts, e.g. "1#0#0#...#"
//             StringBuilder sb = new StringBuilder();
//             for (int i = 0; i < 26; i++) {
//                 sb.append(counts[i]);
//                 sb.append('#'); // separator to avoid ambiguity
//             }
//             String key = sb.toString();

//             // Put in map
//             if (!map.containsKey(key)) {
//                 map.put(key, new ArrayList<String>());
//             }
//             map.get(key).add(s);
//         }

//         return new ArrayList<>(map.values());
//     }
// }



class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // we have a f
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!map.containsKey(key)){
            map.put(key, new ArrayList<String>());
        }
            map.get(key).add(s);

        }

        return new ArrayList<>(map.values());
        

        


        
    }


}
