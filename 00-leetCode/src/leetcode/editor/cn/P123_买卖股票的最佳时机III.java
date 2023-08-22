package leetcode.editor.cn;

/**
 * 买卖股票的最佳时机 III
 * best-time-to-buy-and-sell-stock-iii
 * @author mqinrui
 * @date 2023-08-22 13:52:39
 */
class P123_BestTimeToBuyAndSellStockIii{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P123_BestTimeToBuyAndSellStockIii().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
		//只能交易0次、一次或者两次

		int len  = prices.length;

		//注意dp数组存的是状态
		//dp[i][0、1、2、3、4]，第i天的 状态  ： 没操作过的状态、第一次持有（可能是前面买入的）、第一次卖出(可能是前面卖出的)、第二次持有、第二次卖出
		int[][] dp = new int[len][5];

		//第一天只可能未操作或者买入  错！！！！
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		//同一天可以买入卖出不止一次
		dp[0][2] = 0;
		dp[0][3] = -prices[0];
		dp[0][4] = 0;

		for (int i = 1; i < len; i++) {
			dp[i][0] = dp[i-1][0];
			dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
			dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1] + prices[i]);
			dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] - prices[i]);
			dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
		}


		//两次持有状态一定不是最大  最大值只可能是未操作或者两次卖出后的状态
//		return Math.max(Math.max(dp[len-1][0],dp[len-1][2]),dp[len-1][4]);

		//最大一定是两次卖出的状态
		return dp[len - 1][4];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
