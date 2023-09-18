package leetcode.editor.cn;

/**
 * 飞地的数量
 *
 * @author qr
 * @date 2023-09-18 21:45:07
 */
class P1020_NumberOfEnclaves {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1020_NumberOfEnclaves().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        int isLandCount = 0;
        int totalCount = 0;

        public int numEnclaves(int[][] grid) {
            //找封闭岛屿格子的个数
            int m = grid.length, n = grid[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        if (dfs(grid, i, j)){
                            totalCount += isLandCount;
                        }
                    }
                    isLandCount = 0;
                }
            }
            return totalCount;
        }

        private boolean dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n){
                return false;
            }
            if (visited[i][j] || grid[i][j] == 0){
                return true;
            }

            visited[i][j] = true;
            isLandCount++;
            boolean a = dfs(grid,i,j - 1);
            boolean b = dfs(grid,i,j + 1);
            boolean c = dfs(grid,i - 1,j);
            boolean d = dfs(grid,i + 1,j);

            return a && b && c && d;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
