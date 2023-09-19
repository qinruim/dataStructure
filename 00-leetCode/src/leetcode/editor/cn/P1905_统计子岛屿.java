package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计子岛屿
 * count-sub-islands
 *
 * @author mqinrui
 * @date 2023-09-19 10:02:57
 */
class P1905_CountSubIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1905_CountSubIslands().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
		List<List<int[]>> islands = new ArrayList<>();
		List<int[]> island = new ArrayList<>();

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            //关键在于判断子岛屿：
            // 如果岛屿 B 中存在一片陆地，在岛屿 A 的对应位置是海水，
            // 那么岛屿 B 就不是岛屿 A 的子岛
            int res = 0;
            int m = grid1.length, n = grid1[0].length;
            visited = new boolean[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid1[i][j] == 0 && grid2[i][j] == 1){
						//ij所在岛屿肯定不是子岛屿  淹掉
						dfs(grid2,i,j);
					}
				}
			}

			//不是子岛的淹掉后  剩下的就是 计数
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid2[i][j] == 1){
						res++;
						dfs(grid2,i,j);
					}
				}
			}

			return res;



        }

		private void dfs(int[][] grid, int i, int j) {
			int m = grid.length, n = grid[0].length;
			if (i < 0 || j < 0 || i >= m || j >= n){
				return;
			}
			if (grid[i][j] == 0){
				return;
			}

			grid[i][j] = 0;
			dfs(grid,i - 1,j);
			dfs(grid,i + 1,j);
			dfs(grid,i,j - 1);
			dfs(grid,i,j + 1);

		}


	}
//leetcode submit region end(Prohibit modification and deletion)


}
