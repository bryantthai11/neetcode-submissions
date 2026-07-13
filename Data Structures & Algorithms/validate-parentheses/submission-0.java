class Solution {
    public boolean isValid(String s) {
        //'(', ')', '{', '}', '[' and ']'.

        HashMap<Character, Character> validPairs = new HashMap<>();
        validPairs.put('(',')');
        validPairs.put('{','}');
        validPairs.put('[',']');
        Set<Character> open = new HashSet<>();
        open.add('(');
        open.add('{');
        open.add('[');

        Set<Character> close = new HashSet<>();
        close.add(')');
        close.add('}');
        close.add(']');

        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(open.contains(ch)){
                stack.push(ch);
            }else if(close.contains(ch)){
                if (stack.isEmpty()) return false; // FIX: guard
                char topChar = stack.pop();
                if(validPairs.get(topChar) != ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
