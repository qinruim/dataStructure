package leetcode.editor.cn;

/**
 * 买卖股票的最佳时机
 * best-time-to-buy-and-sell-stock
 * @author mqinrui
 * @date 2023-08-22 10:57:04
 */
class P121_BestTimeToBuyAndSellStock{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P121_BestTimeToBuyAndSellStock().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
		//dp[i][0]:第i天持有股票的最大利润   dp[i][1]:第i天不持有股票的最大利润
		//初始利润为0，买入之后为负
		//最后返回max(dp[n-1][0],dp[n-1][1])
		//递推公式：
		//第i天持有股票时，i-1天可以持有，可以不持有(即第i天买入)： dp[i][0]=dp[i-1][0]  or  dp[i][0] = -prices[i] 取大的
		//第i天不持有股票，同理：dp[i][1]=max(dp[i-1][1],dp[i-1][0]+prices[i])
		if (prices.length == 0 || prices == null){
			return 0;
		}
		int[][] dp = new int[prices.length][2];

		dp[0][0] = -prices[0];
		dp[0][1] = 0;


		for (int i = 1; i < prices.length; i++) {
//			dp[i][0] = Math.max(dp[i - 1][0],dp[i-1][1]-prices[i]);
			//只能买卖一次 如果用dp[i-1][1]-prices[i]，可能出现买卖多次(之前买卖的利润减去当前价格)
			//122 最佳时机II就是买卖多次的情况
			//用-prices[i]，说明新持有的前提是 以前一定没有持有过（0-prices[i]）
			dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i]);
		}

		for (int[] row : dp) {
			for (int e : row) {
				System.out.print(e + "\t");
			}
			System.out.println("\t");
		}

		return Math.max(dp[prices.length - 1][0],dp[prices.length - 1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
