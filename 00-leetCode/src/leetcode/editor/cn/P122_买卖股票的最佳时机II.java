package leetcode.editor.cn;

/**
 * 买卖股票的最佳时机 II
 * best-time-to-buy-and-sell-stock-ii
 *
 * @author mqinrui
 * @date 2023-08-22 13:32:14
 */
class P122_BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P122_BestTimeToBuyAndSellStockIi().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

//            return getMax(prices);
            //自己写一下
            return getMax1(prices);


        }

        private int getMax1(int[] prices) {
            int n = prices.length;//天数
            if (n <= 0) return 0;

            //可以交易k次（无穷次）且可以在当天交易 k永远不变，去掉这个状态
            //持有状态不变：持有 不持有  （当天买入并卖出相当于没有动）
            int[][] dp = new int[n + 1][3];

            dp[0][0] = 0; //不持有
            dp[0][1] = Integer.MIN_VALUE;


            for (int i = 1; i <= n; i++) {
                //max(第i天不动，第i天卖出)
                dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i - 1]);
                //max(第i天不动，第i天买入)
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);

            }
            return dp[n][0];
        }

        private int getMax(int[] prices) {
            int len = prices.length;

            //dp[i][0]:第i天持有   dp[i][1]:第i天不持有
            int[][] dp = new int[len][2];

            dp[0][0] = -prices[0];
            dp[0][1] = 0;

            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            }
            return Math.max(dp[len - 1][0], dp[len - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
