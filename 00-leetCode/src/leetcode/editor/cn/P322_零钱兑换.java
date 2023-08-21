package leetcode.editor.cn;

import jdk.nashorn.internal.ir.IfNode;

import java.util.function.DoublePredicate;

/**
 * 零钱兑换
 * coin-change
 * @author mqinrui
 * @date 2023-08-21 11:34:16
 */
class P322_CoinChange{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P322_CoinChange().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		//有题目可知 dp[0] = 0
		//因为后面取最小值 除了第一个元素 初始化成大值 避免被覆盖
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		//凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，
		//那么只需要加上一个钱币coins[i]即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
		//所以dp[j] 要取所有 dp[j - coins[i]] + 1 中最小的。
		//递推公式：dp[j] = min(dp[j - coins[i]] + 1, dp[j]);

		//题目要找到物品数量最少的那一种组合，因此排列、组合都可以
		for (int j = 1; j <= amount; j++) {
			for (int i = 0; i < coins.length; i++) {
				//如果该位是初始最大值，➕1之后超过int范围了，发生溢出
				//因为dp[j-coins[i]]==Integer.MAX_VALUE说明，容量为j-coins[i]的情况下暂时还是没解的，可以直接跳过
				if(j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE){
					dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
				}
			}
		}

		for (int e : dp) {
			System.out.print(e + "\t");
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
