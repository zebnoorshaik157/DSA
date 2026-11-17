class Solution {
    public boolean validTree(int n, int[][] edges) {

        int m = edges.length;

        if (m != n - 1) {
            return false;
        }

        boolean[] vis = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int cnt = 1;
        int start = 0;

        Queue<Integer> q = new LinkedList<>();

        vis[start] = true;
        q.add(start);

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int nei : adj.get(curr)) {

                if (!vis[nei]) {
                    vis[nei] = true;
                    q.add(nei);
                    cnt++;
                }
            }
        }

        return cnt == n;
    }
}
