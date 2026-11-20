class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> nextdp = new HashMap<>();
            for (int sum : dp.keySet()) {
                int cnt = dp.get(sum);

                nextdp.put(sum + num, nextdp.getOrDefault(sum + num, 0) + cnt);
                nextdp.put(sum - num, nextdp.getOrDefault(sum - num, 0) + cnt);
            }
            dp = nextdp;
        }
        return dp.getOrDefault(target, 0);
    }
}
