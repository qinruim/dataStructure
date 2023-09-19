package leetcode.editor.cn;

/**
 * 岛屿的最大面积
 * @author qr
 * @date 2023-09-18 22:10:53
 */
class P695_MaxAreaOfIsland{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P695_MaxAreaOfIsland().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 boolean[][] visited;
		 int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
		int res = Integer.MIN_VALUE;
		//记录每一个岛屿的面积 并更新
		int m = grid.length,n = grid[0].length;
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]){
					dfs(grid,i,j);
					res = Math.max(res,count);
				}
				count = 0;
			}
		}
		return res == Integer.MIN_VALUE ? 0 : res;
    }

	private void dfs(int[][] grid, int i, int j) {
		int m = grid.length,n = grid[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n){
			return;
		}
		if (visited[i][j] || grid[i][j] == 0){
			return;
		}

		visited[i][j] = true;
		count++;
		dfs(grid,i - 1,j);
		dfs(grid,i + 1,j);
		dfs(grid,i,j - 1);
		dfs(grid,i,j + 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
