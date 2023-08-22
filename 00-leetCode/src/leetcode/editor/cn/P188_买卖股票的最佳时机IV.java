package leetcode.editor.cn;

/**
 * 买卖股票的最佳时机 IV
 * best-time-to-buy-and-sell-stock-iv
 * @author mqinrui
 * @date 2023-08-22 11:22:16
 */
class P188_BestTimeToBuyAndSellStockIv{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P188_BestTimeToBuyAndSellStockIv().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
		int len = prices.length;
		if (len == 0){
			return 0;
		}

		//最多k次 需要2k种状态
		int[][] dp = new int[len][2 * k + 1];

		//初始化第一天的状态
		for (int i = 1; i < 2*k; i+=2) {
			//除了0以外，奇数是持有，为-prices[i]  偶数是卖出,为0
			dp[0][i] = -prices[0];
		}

		for (int i = 1; i < len; i++) {
			//第i天，第k次持有：dp[i][2k-1];第k次卖出：dp[i][2k]
			for (int j = 1; j < 2*k; j+=2) {
				dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - 1] - prices[i]);
				dp[i][j + 1] = Math.max(dp[i - 1][j + 1],dp[i - 1][j] + prices[i]);
			}

		}

		return dp[len - 1][2*k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
