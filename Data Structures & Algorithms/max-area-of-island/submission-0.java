
class Solution {

    private int bfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 0;

        int area = 1;

        area += bfs(grid, i + 1, j);
        area += bfs(grid, i - 1, j);
        area += bfs(grid, i, j + 1);
        area += bfs(grid, i, j - 1);

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {

                    int area = bfs(grid, i, j);

                    cnt = Math.max(cnt, area);
                }
            }
        }

        return cnt;
    }
}
