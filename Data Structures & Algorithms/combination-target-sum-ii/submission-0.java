
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    private void backtrack(int index, int[] nums, int target,
                           List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Since array is sorted
            if (nums[i] > target) {
                break;
            }

            ds.add(nums[i]);

            // Move to next index because each element is used once
            backtrack(i + 1, nums, target - nums[i], ans, ds);

            // Backtracking
            ds.remove(ds.size() - 1);
        }
    }
}
