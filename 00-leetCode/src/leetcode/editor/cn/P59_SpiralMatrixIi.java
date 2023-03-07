package leetcode.editor.cn;

/**
 * 螺旋矩阵 II
 * @author qr
 * @date 2023-03-07 22:20:40
 */
public class P59_SpiralMatrixIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P59_SpiralMatrixIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
		int[][] res =  new int[n][n]; // 定义一个二维数组
		int startX = 0, startY = 0; // 定义每循环一个圈的起始位置
		int loop = n / 2; // 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
		int mid = n / 2; // 矩阵中间的位置索引，例如：n为3， 中间的位置就是(1，1)，n为5，中间位置为(2, 2)
		int count = 1; // 用来给矩阵中每一个空格赋值
		int offset = 1; // 需要控制每一条边遍历的长度，每次循环右边界收缩一位
		int i,j; //(i.j)

		while (loop > 0){
			// 下面开始的四个for就是模拟转了一圈
			// 模拟填充上行从左到右(左闭右开)
			for (j = startY; j < n - offset ; j++) {
				res[startX][j] = count++;
			}
			// 模拟填充右列从上到下(左闭右开)
			for (i = startX; i < n -offset; i++) {
				res[i][j] = count++;
			}
			//下行从右到左
			for (; j > startY ; j--) {
				res[i][j] = count++;
			}
			//左列从下到上
			for (; i > startX ; i--) {
				res[i][j] = count++;
			}
			// 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
			startX++;
			startY++;
			// offset 控制每一圈里每一条边遍历的长度
			offset++;

			loop--;
		}

		//如果是奇数，中心位置单独肤质
		if (n%2 == 1){
			res[mid][mid] = count;
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
