package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 岛屿数量
 * number-of-islands
 * @author mqinrui
 * @date 2023-09-18 15:25:32
 */
class P200_NumberOfIslands{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P200_NumberOfIslands().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 boolean[][] visited;
    public int numIslands(char[][] grid) {
		int res = 0;
		int m = grid.length,n = grid[0].length;
		visited = new boolean[m][n];

		//遍历grid
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]){
					//发现岛屿
					res++;
					//dfs把岛屿淹没 即把连成片的的1淹没 这样下一次遇到1就是没有连起来的 新的岛屿
					//淹没是为了防止走回头路 是visited数组的替代
					dfs(grid,i,j);
				}
			}
		}


		return res;
    }

	/**
	 * 从i，j开始将其相邻的陆地都变成海水
	 * @param grid
	 * @param i
	 * @param j
	 */
	private void dfs(char[][] grid, int i, int j) {
		int m = grid.length,n = grid[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n){
			//索引越界
			return;
		}
		if (grid[i][j] == '0'){
			return;
		}
		if (visited[i][j]){
			return;
		}
//		grid[i][j] = '0';
		visited[i][j] = true;

		dfs(grid,i - 1,j);
		dfs(grid,i + 1,j);
		dfs(grid,i,j - 1);
		dfs(grid,i,j + 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
