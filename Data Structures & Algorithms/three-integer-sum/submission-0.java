class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //first sort the array
        //need to find i starting point, this should be the right most indexed value if there are duplicates
        //proceed only if i + 1 != i
        //need to repeat for j and k
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();        int sum = 0;
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] > 0){
                break;
            }
            int j = i + 1; int k = nums.length - 1;
            while(j < k ){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    //add this combination to the ans list
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1] ){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }

                }else if(sum > 0){
                        k--;
                }else{
                    j++;
                }
        }

               
            }
                    return ans;

        }
}

