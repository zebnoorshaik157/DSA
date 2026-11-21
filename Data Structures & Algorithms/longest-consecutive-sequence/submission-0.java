class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int longest = 1;
        Set<Integer> st = new HashSet<>();

        for (int num : nums) {
            st.add(num);
        }

        for (int num : st) {
            if (!st.contains(num - 1)) {
                int length = 1;
                while (st.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
