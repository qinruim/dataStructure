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
//		return getmaxProfit(k,prices);
		//自己写一下
		return getmaxProfit1(k,prices);

    }

	private int getmaxProfit1(int k, int[] prices) {
		int n = prices.length; //天数
		if (n <= 0) return 0;

		//三个状态：天数，交易次数，持有/不持有
		//dp[i][j][0/1]：第i天，第j次交易，持有/不持有 状态下的最大利润
		int[][][] dp = new int[n + 1][k + 1][2];

		//初始化
		//k从1开始 k=0 时，不允许交易 不持有利润当然为0；因为此时不可能持有股票，因此让他等于一个最小值 方便求最大
		for (int i = 0; i <= n; i++) {
			dp[i][0][0] = 0;
			dp[i][0][1] = Integer.MIN_VALUE;
		}
		//n从1开始，n=0时代表还没开始 利润为0
		for (int j = 0; j <= k; j++) {
			dp[0][j][0] = 0;
			dp[0][j][1] = Integer.MIN_VALUE;
		}

		//状态转移 三种选择 买、卖、不动
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				//在买入时记一次交易
				//max(今天不动，今天卖出)
				dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i - 1]);//价格数组的索引从0开始
				//max(今天不动，今天买入)
				dp[i][j][1] = Math.max(dp[i - 1][j][1],dp[i - 1][j - 1][0] - prices[i - 1]);
			}
		}

		return dp[n][k][0];
	}

	private int getmaxProfit(int k, int[] prices) {
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
