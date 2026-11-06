class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resSet = new ArrayList<>();

        backtrack(resSet, new ArrayList<>(), nums, 0);
        return resSet;
    }
    private void backtrack(
        List<List<Integer>> resSet, List<Integer> tempSet, int[] nums, int start) {
        resSet.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            tempSet.add(nums[i]);
            backtrack(resSet, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}
