class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, ans, subset, nums);
        return ans;
    }

    private void dfs(int i, List<List<Integer>> ans, List<Integer> subset, int[] nums){
        if(i >= nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i + 1, ans, subset, nums);
        subset.remove(subset.size() - 1);
        dfs(i + 1, ans, subset, nums);
    }
}
