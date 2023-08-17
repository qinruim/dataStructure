package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 * n-queens
 *
 * @author mqinrui
 * @date 2023-08-17 15:52:59
 */
class P51_NQueens {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P51_NQueens().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private ArrayList<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] chessBoard = new char[n][n];
            for (char[] chars : chessBoard) {
                Arrays.fill(chars, '.');
            }

            int row = 0; //row记录当前在第几行 从0开始到n-1结束
            backTracking(n, row, chessBoard);

            return result;
        }

        private void backTracking(int n, int row, char[][] chessBoard) {
            //终止条件 遍历到叶子节点
            if (row == n) {
                result.add(arrayToList(chessBoard));
                return;
            }

            //遍历每行n个格子 递归
            //棋盘的宽度就是for循环的长度，递归的深度就是棋盘的高度
            for (int col = 0; col < n; col++) {
                if (isValid(row, col, n, chessBoard)) {
                    chessBoard[row][col] = 'Q';
                    backTracking(n, row + 1, chessBoard);
                    chessBoard[row][col] = '.';
                }

            }
        }

        //二维数组棋盘转成List<List<String>
        private List<String> arrayToList(char[][] chessBoard) {
            ArrayList<String> list = new ArrayList<>();
            //一行是一个list<String>
            for (char[] chars : chessBoard) {
                list.add(String.copyValueOf(chars));
            }
            return list;
        }

        private boolean isValid(int row, int col, int n, char[][] chessBoard) {
            //棋盘（result）中Q不能同行 同列 同斜线
            //当前准备添加的Q在row行col列，判断当前位置前面的即可

            //同行不用判断 因为回溯时保证了每行只有一个元素

            //同列
            for (int i = 0; i < row; i++) {
                if (chessBoard[i][col] == 'Q') {
                    return false;
                }
            }

            //同斜线
            //45度（左上角）
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessBoard[i][j] == 'Q') {
                    return false;
                }
            }
            //135度（右上角）
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (chessBoard[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
