package leetcode.editor.cn;

/**
 * 统计封闭岛屿的数目
 * number-of-closed-islands
 *
 * @author mqinrui
 * @date 2023-09-18 15:44:40
 */
class P1254_NumberOfClosedIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1254_NumberOfClosedIslands().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;

        public int closedIsland(int[][] grid) {
            int res = 0;
            int m = grid.length, n = grid[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //需要把dfs放在三个条件的最后，否则会影响前两个的值
                    if (!visited[i][j] && grid[i][j] == 0 && dfs(grid, i, j)) {
                        res++;
                    }
                }
            }
            return res;
        }

        /**
         * 要四个方向都返回true（碰到海水） 才返回true
         *
         * @param grid
         * @param i
         * @param j
         * @return
         */
        private boolean dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return false;
            }
            if (visited[i][j] || grid[i][j] == 1) {
                return true;
            }
            visited[i][j] = true;
//            grid[i][j] = -1;
            boolean a = dfs(grid, i, j - 1);
            boolean b = dfs(grid, i, j + 1);
            boolean c = dfs(grid, i - 1, j);
            boolean d = dfs(grid, i + 1, j);

            return a && b && c && d;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
