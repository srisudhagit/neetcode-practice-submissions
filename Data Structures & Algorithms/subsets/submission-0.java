class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();

        List<Integer> currSubset = new ArrayList<>();

        dfs(nums, 0, subsetList, currSubset);

        return subsetList;
    }


    public void dfs(int[] nums, int pos, List<List<Integer>> subsetList,List<Integer> currSubset){
        if(pos >= nums.length){
            subsetList.add(new ArrayList<>(currSubset));
            return;
        }
        currSubset.add(nums[pos]);
        dfs(nums, pos+1, subsetList, currSubset);

        currSubset.remove(currSubset.size()-1);
        dfs(nums, pos+1, subsetList, currSubset);
    }
}
