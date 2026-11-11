class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            cnt[tasks[i] - 'A']++;
        }
        Arrays.sort(cnt);
        int maxfreq = cnt[25];
        int idle = (maxfreq - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxfreq - 1, cnt[i]);
        }
        idle = Math.max(0, idle);
        return tasks.length + idle;
    }
}
