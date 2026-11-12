class Solution {
    private void bfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') 
            return;
            grid[i][j]='0';
        bfs(grid, i + 1, j);
        bfs(grid, i - 1, j);
        bfs(grid, i, j + 1);
        bfs(grid, i, j - 1);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                     cnt++;
                    bfs(grid, i, j);
                   
                }
            }
        }
        return cnt;
    }
}
