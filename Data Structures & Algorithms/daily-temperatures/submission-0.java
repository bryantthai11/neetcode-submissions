class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            int curr = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < curr){
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
