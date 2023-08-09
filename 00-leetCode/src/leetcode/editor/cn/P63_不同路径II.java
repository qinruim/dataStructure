package leetcode.editor.cn;

/**
 * 不同路径 II
 * unique-paths-ii
 * @author mqinrui
 * @date 2023-08-09 16:02:04
 */
class P63_UniquePathsIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P63_UniquePathsIi().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 *思路：在P62的基础上 添加路径是否可行的判断
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {


		return getPaths(obstacleGrid);

    }

	private int getPaths(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		//起点或终点出现障碍 直接返回0
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
			return 0;
		}

		int[][] dp = new int[m][n];



		//初始化
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0){
				dp[i][0] = 1;
			}else {
				//出现障碍 从这里往后都是0  无路,即保持初始值
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 0){
				dp[0][i] = 1;
			}else {
				//出现障碍 从这里往后都是0  无路
				break;
			}
		}

		//遍历
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1){
//					dp[i][j] = 0;
					continue;
				}
				else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}



		return dp[m - 1][n - 1];
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
