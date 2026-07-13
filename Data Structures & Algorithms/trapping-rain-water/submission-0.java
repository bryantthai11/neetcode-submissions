class Solution {
    // public int trap(int[] height) {
    //     //looks like we need to count the height, there is only trapped water
    //     //if left and right bounds have space inbetween with all values less than the value of the bars
    //     //calculating the area is (right - left - 1)  * (height of the min of left and right) - height of all values inbetween left and right 
    //     //i am so stupid, it is the total rain water, i thought it was the most trapped between two bars, so i would have to do a greedy algorithm, this simplifies things
    //     //

    //     //basically we have a left and right ptr, we increment the right ptr, until we encounter a bar that is equal or greater than left bar

    //     int maxRain = 0;
    //     int n = height.length;
    //     int l = 0;
    //     while(l < n && height[l] == 0){
    //         l++;
    //     }
    //     //start left at first valid bar
    //     int l = i;
    //     for(int right = l + 1; right < n; right++){
    //         Deq
    //     }

    // }
    public int trap(int[] height) {
    int l = 0, r = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int water = 0;

    while (l < r) {
        if (height[l] < height[r]) {
            leftMax = Math.max(leftMax, height[l]);
            water += leftMax - height[l];
            l++;
        } else {
            rightMax = Math.max(rightMax, height[r]);
            water += rightMax - height[r];
            r--;
        }
    }
    return water;
}
}
