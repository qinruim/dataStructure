package leetcode.editor.cn;

/**
 * 买卖股票的最佳时机含冷冻期
 * best-time-to-buy-and-sell-stock-with-cooldown
 * @author mqinrui
 * @date 2023-08-22 16:40:26
 */
class P309_BestTimeToBuyAndSellStockWithCooldown{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
//		return getMax(prices);
		//自己写一下
		return getMax1(prices);
    }

	private int getMax1(int[] prices) {
		int n = prices.length; //天数
		if (n == 0 || n == 1) return 0;

		//n>=2
		//一天冷冻期 交易次数不限
		//状态不变 第i天买入的时候，从第i-2天转移
		int[][] dp = new int[n + 1][2];
		dp[0][0] = 0;
		dp[0][1] = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			if (i - 2 < 0){
				//即i=1
				dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i - 1]);
				dp[i][1] = -prices[i - 1];
				continue;
			}
			dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i - 1]);
			//dp[i-2][0] - prices[i]
			//要在第i天买，所以第i-1天一定不能卖！其实第i-1天一共有三种可能，买 or 卖 or 不动
			//如果i-1天买或者卖（冷冻） 第i天都不能买
			//只能第i-1天不动，即第i-2天不持有，保持到第i天，才能在第i天买入
			dp[i][1] = Math.max(dp[i - 1][1],dp[i - 2][0] - prices[i - 1]);
		}

		return dp[n][0];
	}

	private int getMax(int[] prices) {
		int len = prices.length;

		if (len == 0 || len == 1){
			return 0;
		}

		//dp[i][j]: 第i天状态:0-持有，1-保持不持有的状态，2-当前卖出的状态，3-冷冻
		//中间两种是将不持有的状态分开了 因为当前卖出，下一天就冷冻     要确定冷冻期

		int[][] dp = new int[len][4];

		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		dp[0][2] = 0;
		dp[0][3] = 0;

		for (int i = 1; i < len; i++) {
			//持有：一直持有，保持不持有的下一天买入，冷冻的下一天买入 三个来源
			dp[i][0] = Math.max(Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]),dp[i - 1][3] - prices[i]);
			//保持不持有：前一天不持有，前一天冷冻
			dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][3]);
			//当前卖出：前一天持有
			dp[i][2] = dp[i - 1][0] + prices[i];
			//冷冻：前一天卖出
			dp[i][3] = dp[i - 1][2];
		}

		return Math.max(Math.max(dp[len - 1][2],dp[len - 1][3]),dp[len - 1][1]);

	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
