package leetcode.editor.cn;

/**
 * 买卖股票的最佳时机含手续费
 * best-time-to-buy-and-sell-stock-with-transaction-fee
 * @author mqinrui
 * @date 2023-08-22 17:23:20
 */
class P714_BestTimeToBuyAndSellStockWithTransactionFee{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P714_BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices, int fee) {
		int len = prices.length;

		//在卖出时交手续费 dp[0][0] 初始化成 -prices[i]
		//在买入时交手续费 dp[0][0] 初始化成 -prices[i] - fee
		//dp[i][0]:持有  dp[i][1]:不持有
		int[][] dp = new int[len][2];

//		dp[0][0] = -prices[0];
		dp[0][0] = -prices[0] - fee;
		dp[0][1] = 0;

		for (int i = 1; i < len; i++) {
			//前一天持有、不持有两种
			dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i] - fee);
//			dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]);
			//同上
			dp[i][1] = Math.max(dp[i - 1][0] + prices[i],dp[i - 1][1]);
//			dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee,dp[i - 1][1]);
		}

		for (int[] row : dp) {
			for (int e : row) {
				System.out.print(e + "\t");
			}
			System.out.println("\t");
		}

		return dp[len - 1][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
