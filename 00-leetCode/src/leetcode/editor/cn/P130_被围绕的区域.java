package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 被围绕的区域
 * surrounded-regions
 *
 * @author mqinrui
 * @date 2023-09-18 16:25:00
 */
class P130_SurroundedRegions {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P130_SurroundedRegions().new Solution();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }


        System.out.println("==========");


        solution.solve(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        LinkedList<int[]> isLand = new LinkedList<>();
        List<List<int[]>> isLands = new ArrayList<>();

        public void solve(char[][] board) {
            int m = board.length, n = board[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] == 'O' && dfs(board, i, j)) {
//                        board[i][j] = 'X';
                        isLands.add(new LinkedList<>(isLand));
                    }
                    isLand.clear();
                }
            }

            for (List<int[]> land : isLands) {
                for (int[] pos : land) {
                    board[pos[0]][pos[1]] = 'X';
                }
            }
        }

        private boolean dfs(char[][] board, int i, int j) {
            int m = board.length, n = board[0].length;

            if (i < 0 || j < 0 || i >= m || j >= n) {
                return false;
            }
            if (visited[i][j] || board[i][j] == 'X') {
                return true;
            }

            visited[i][j] = true;

            int[] pos = new int[]{i, j};
            isLand.add(pos);

            boolean a = dfs(board, i, j - 1);
            boolean b = dfs(board, i, j + 1);
            boolean c = dfs(board, i - 1, j);
            boolean d = dfs(board, i + 1, j);
//            visited[i][j] = false;
            return a && b && c && d;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
