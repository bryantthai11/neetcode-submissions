class Solution {
    public int largestRectangleArea(int[] heights) {
        int[][] idxToVal = new int[heights.length][2];
        for(int i = 0; i < heights.length; i++){
            idxToVal[i][0] = i;
            idxToVal[i][1] = heights[i];
        }
        int maxArea = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for(int[] arr : idxToVal){
            int idx = arr[0];
            int start = arr[0];

            int height = arr[1];
            while(!stack.isEmpty() && height < stack.peek()[1]){
                //we need to pop the element, and calculate the max area
                int[] tmp = stack.pop();
                
                maxArea = Math.max(maxArea, tmp[1] * (idx - tmp[0]));
                start = tmp[0];
            }
            stack.push(new int[] {start, height});
            
        }

        //that is all of them
        int n = heights.length;
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            maxArea = Math.max(maxArea, arr[1] * (n - arr[0]));
        }
        return maxArea;
    }
}
