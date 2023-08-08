package leetcode.editor.cn;

/**
 * 使用最小花费爬楼梯
 * min-cost-climbing-stairs
 * @author mqinrui
 * @date 2023-08-08 15:49:49
 */
class P746_MinCostClimbingStairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P746_MinCostClimbingStairs().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * dp数组含义-dp[i]:跳到i楼需要花费的体力
	 * 递推公式： i-1到i的花费： dp[i-1] + cost[i-1]
	 * 			i-2到i的花费： dp[i-2] + cost[i-2]
	 * 		  	所以 dp[i] = min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2])
	 * @param cost
	 * @return
	 */
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n + 1];

		//可以省略  后面包含了这部分
//		if (n == 0){
//			return cost[0];
//		}
//		if (n == 1){
//			return Math.min(cost[0],cost[1]);
//		}

		//初始化dp数组
		dp[0] = 0;
		dp[1] = 0;

		//遍历 本题从前往后遍历
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2]+cost[i - 2]);
		}

		//打印dp数组  debug用
		for (int i : dp) {
			System.out.println(i);
		}

		return dp[n]; //楼顶
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
