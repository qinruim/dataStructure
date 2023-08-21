package leetcode.editor.cn;

/**
 * 完全平方数
 * perfect-squares
 * @author mqinrui
 * @date 2023-08-21 15:37:31
 */
class P279_PerfectSquares{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P279_PerfectSquares().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
		/**
		 * 容量n 物品集合{1^2,2^1.....√n^2}
		 * 完全背包
		 */
		int[] nums = new int[((int) Math.sqrt(n))];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (i + 1) * (i + 1);
//			System.out.print(nums[i]);
		}

		int max = Integer.MAX_VALUE;
		//dp[j] : 装满容量为j 的组合的最少的元素个数
		int[] dp = new int[n + 1];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = max;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = nums[i]; j <= n ; j++) {
				//不需要這個if statement，因爲在完全平方數這一題不會有"湊不成"的狀況發生
				// （ 一定可以用"1"來組成任何一個n），故comment掉這個if statement。
//				if (dp[j - nums[i]] != max){
					dp[j] = Math.min(dp[j],dp[j - nums[i]] + 1);
//				}
			}
		}

		for (int e : dp) {
			System.out.print(e + "\t");
		}


		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
