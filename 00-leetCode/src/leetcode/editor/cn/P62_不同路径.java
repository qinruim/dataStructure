package leetcode.editor.cn;

/**
 * 不同路径
 * unique-paths
 * @author mqinrui
 * @date 2023-08-09 15:42:59
 */
class P62_UniquePaths{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P62_UniquePaths().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**动态规划
	 * 思路： dp[i][j]:表示从（0，0）出发到（i，j）的路径条数
	 * 		显然：（i，j）只能从（i-1，j）或 （i，j-1） 向右或向下一步到达
	 * 		所以： dp[i][j] = dp[i-1][j] + dp[i][j-1]
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {




		return getUniquePath(m,n);



    }

	private int getUniquePath(int m, int n) {
		int[][] dp = new int[m][n];
		//初始化dp数组，显然dp[i][0] 只能是1 ；dp[0][j]同理
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		//遍历
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[m - 1][n - 1];




	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
