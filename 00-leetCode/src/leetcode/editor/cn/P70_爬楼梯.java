package leetcode.editor.cn;

/**
 * 爬楼梯
 * climbing-stairs
 * @author mqinrui
 * @date 2023-08-08 15:01:32
 */
class P70_ClimbingStairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P70_ClimbingStairs().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 这题很像 509. 斐波那契数：爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
	 * 因为 n - 1 和 n - 2 都能一步到 n ；即先到 n - 1，再到 n 的方法个数；和先到 n - 2 再到 n 的方法个数之和
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {

		int[] dp = new int[n + 1];
		if (n <= 2){
			return n;
		}

		dp[1] = 1;
		dp[2] = 2;

		int sum = 0;

		for (int i = 3; i <= n; i++) {
//			dp[i] = dp[i - 1] + dp[i - 2];
			sum = dp[1] + dp[2];
			dp[1] = dp[2];
			dp[2] = sum;

		}

//		return dp[n];
		return sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
