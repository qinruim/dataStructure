package leetcode.editor.cn;

/**
 * N 皇后 II
 * n-queens-ii
 * @author mqinrui
 * @date 2023-09-01 15:49:11
 */
class P52_NQueensIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P52_NQueensIi().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 int res = 0;
    public int totalNQueens(int n) {
		int[][] chessBoard = new int[n][n];
		backTrack(chessBoard,0);
		return res;
    }

	private void backTrack(int[][] chessBoard, int row) {
		int n = chessBoard.length;
		if (row == n){
			res++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isValidPos(chessBoard,row,col)){
				chessBoard[row][col] = 1;
				backTrack(chessBoard,row + 1);
				chessBoard[row][col] = 0;
			}
		}
	}

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
