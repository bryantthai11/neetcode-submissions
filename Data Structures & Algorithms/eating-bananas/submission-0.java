class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        int ans = 0;
        for(int p : piles){
            right = Math.max(right, p); 
        }
        int left = 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //check validity
            int totalHours = 0;
            for(int p : piles){
                totalHours += (p + mid - 1) / mid;   // integer ceil division
            }
            if(totalHours <= h){
                //is a valid num lets add it and lets shrink the size
                ans = mid;
                right = mid - 1;
            }else{
                left = mid  + 1;
            }
        }
        return ans;
    }
}
