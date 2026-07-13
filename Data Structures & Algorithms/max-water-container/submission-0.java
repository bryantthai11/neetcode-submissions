class Solution {
    public int maxArea(int[] heights) {
        //the area between two bars is going to be the lowest height of the two times right - left index;
        //we can just do this brute force and calculate all of them, but we want to be greedy, what would be the best way to do this?
        //We move the shorter bar in search of a potentially larger bar
        int left = 0;
        int right = heights.length - 1;
        int area = 0;

        while(left < right){
            int width = right - left;
            int side = Math.min(heights[left], heights[right]);

            area = Math.max(area, width * side);
            if(heights[left] > heights[right]){
                right--;
            }else{
                left++;
            }
        }
        return area;
    }
}
