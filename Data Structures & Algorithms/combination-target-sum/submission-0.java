class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();

        backtrack(0,nums,target,ans,new ArrayList<>()); 
        return ans;
    }
    private void backtrack(int index,int[] nums,int target,List<List<Integer>> ans,List<Integer> ds) {
        if(index==nums.length) {
            if(target==0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(nums[index] <= target) {

            ds.add(nums[index]);
            backtrack(index,nums,target-nums[index],ans,ds);
            ds.remove(ds.size()-1);
        }
            backtrack(index+1,nums,target,ans,ds);
    }
}
