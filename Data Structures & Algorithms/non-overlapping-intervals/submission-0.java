class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,Comparator.comparingInt(i->i[1]));
        int cnt=1;
        int lastInterval=intervals[0][1];

        for(int i=1;i<n;i++) {
            if(intervals[i][0] >=lastInterval) {
                cnt++;
                lastInterval=intervals[i][1];
            }
        }
        return n-cnt;
    }
}
