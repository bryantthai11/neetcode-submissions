class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //so we have to make a set of unique combinations, we could utilize dfs in order to find all possibilities, our check condition is a little harder since we are allowed to utilize a num in nums an unlimited amount of times. we should look to sort nums then utilize a left and right pointer was my first intuition, this is pretty much where i am kind of stuck, i am not sure if i should ultilize dfs with some type of check, eh lets try to code this out and see whwere i get.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, res, combo, 0, target);
        return res;
    }
    public void dfs(int i,  int [] nums, List<List<Integer>> res, List<Integer> combo, int currSum, int target){
        if(currSum == target){
            res.add(new ArrayList<>(combo));
            return;
        }
        if(i >= nums.length || currSum > target){
            return;
        }
        combo.add(nums[i]);
        dfs(i, nums, res, combo, currSum + nums[i], target);

        combo.remove(combo.size() - 1);
        dfs(i + 1, nums, res, combo, currSum, target);
    }
}
