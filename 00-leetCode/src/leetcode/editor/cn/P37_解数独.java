package leetcode.editor.cn;

/**
 * 解数独
 * sudoku-solver
 *
 * @author mqinrui
 * @date 2023-08-17 17:10:13
 */
class P37_SudokuSolver {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P37_SudokuSolver().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            backTracking(board);
        }

        private boolean backTracking(char[][] board) {
//            if (row >= 9) {
//                return;
//            }

            //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
            // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
            for (int row = 0; row < 9; row++) { //遍历行
                for (int col = 0; col < 9; col++) {    //遍历列
                    //在一行内
                    if (board[row][col] != '.') {
                        continue;
                    }

                    //满足三条要求再往下递归
                    //当前位置分别放9个元素往下递归
                    for (char element = '1'; element <= '9'; element++) {
                        if (isValid(board, row, col,element)) {
                            board[row][col] = element;
                            // 如果找到合适一组立刻返回
                            if (backTracking(board)){
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    // 9个数都试完了，都不行，那么就返回false
                    return false;
                    // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                    // 那么会直接返回false， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」

                }
            }
            // 遍历完没有返回false，说明找到了合适棋盘位置了
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char element) {
            //同行重复
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == element){
                    return false;
                }
            }
            //同列重复
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == element){
                    return false;
                }
            }
            //九宫格里重复
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;

            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] == element){
                        return false;
                    }
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
