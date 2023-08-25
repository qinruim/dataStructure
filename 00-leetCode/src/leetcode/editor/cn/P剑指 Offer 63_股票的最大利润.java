package leetcode.editor.cn;

/**
 * 股票的最大利润
 * gu-piao-de-zui-da-li-run-lcof
 * @author mqinrui
 * @date 2023-08-23 10:59:32
 */
class P剑指Offer63_GuPiaoDeZuiDaLiRunLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P剑指Offer63_GuPiaoDeZuiDaLiRunLcof().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0 || len == 1){
			return 0;
		}
		int[][] dp = new int[len][2];

		dp[0][0] = -prices[0];

		for (int i = 1; i < len; i++) {
			dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] + prices[i],dp[i - 1][1]);


		}
		return dp[len - 1][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
