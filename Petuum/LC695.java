package Petuum;

public class LC695 {
    int max = 0;
    int[][] steps = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(i, j, visited, grid);
            }
        }
        return max;
    }

    public int dfs(int i, int j, boolean[][] visited,int[][] grid) {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||visited[i][j])
            return 0;
        int ans = 0;
        if(grid[i][j]==1)
        {
            ans += 1;
            visited[i][j] = true;
            for (int[] step : steps) {
                ans += dfs(i + step[0], j + step[1], visited, grid);
            }
        }
        else
            ans = 0;
        max = Math.max(max, ans);
        return ans;
    }
}
