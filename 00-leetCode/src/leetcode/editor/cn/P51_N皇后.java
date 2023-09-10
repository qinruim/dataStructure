package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
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
        LinkedList<List<String>> res = new LinkedList<>();
        public List<List<String>> solveNQueens(int n) {
            //构建棋盘 初始为0，有棋子置1  按题目要求  只有每行一个棋子才能满足
            int[][] chessBoard = new int[n][n];
            backTrack(chessBoard,0);
            return res;
        }

        /**
         * 传入棋盘 穷举所有可能
         *
         * @param chessBoard
         * @param row
         */
        private void backTrack(int[][] chessBoard, int row) {
            int n = chessBoard.length;
            if (row == n){
                res.add(ArrayToList(chessBoard));
                return;
            }

            //一层递归是一行  一个for循环是一列
            for (int col = 0; col < n; col++) {
                //当前位置满足要求 加入track
                if (isValidPos(chessBoard,row,col)){
                    chessBoard[row][col] = 1;
                    backTrack(chessBoard,row + 1);
                    chessBoard[row][col] = 0;
                }
            }


        }

        /**
         * 将数组形式的棋盘转成List
         * @param chessBoard
         * @return
         */
        private List<String> ArrayToList(int[][] chessBoard) {
            List<String> res = new ArrayList<>();
            for (int[] row : chessBoard) {
                StringBuilder sb = new StringBuilder();
                for (int e : row) {
                    if (e == 0){
                        sb.append('.');
                    }else if (e == 1){
                        sb.append('Q');
                    }
                }
                res.add(sb.toString());
            }
            return res;
        }

        /**
         * 判断当前位置是否可以放皇后
         * @param chessBoard
         * @param row
         * @param col
         * @return
         */
        private boolean isValidPos(int[][] chessBoard, int row, int col) {
            int n = chessBoard.length;
            //1.同列不能有（一行只放一个棋子 同行不必检查）
            for (int i = 0; i < n; i++) {
                if (chessBoard[i][col] == 1){
                    return false;
                }
            }
            //2.斜线上不能有  下方还没放棋子  检查左上方和右上方即可
            //左上方
            for (int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
                if (chessBoard[i][j] == 1){
                    return false;
                }
            }
            //右上方
            for (int i = row - 1,j = col + 1; i >= 0 && j < n; i--,j++) {
                if (chessBoard[i][j] == 1){
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}
