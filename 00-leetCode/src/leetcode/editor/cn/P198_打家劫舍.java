package leetcode.editor.cn;

import java.util.function.DoublePredicate;

/**
 * 打家劫舍
 * house-robber
 * @author mqinrui
 * @date 2023-08-21 16:53:43
 */
class P198_HouseRobber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P198_HouseRobber().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
		if (nums.length == 0){
			return 0;
		}
		if (nums.length == 1){
			return nums[0];
		}
//		if (nums.length == 2){
//			return Math.max(nums[0],nums[1]);
//		}
		//dp[i]:考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
		//偷第i个房间，dp[i] = dp[i-2]+nums[i]  不偷第i个房间：dp[i] = dp[i - 1]
		//取二者较小的那个
//		int[] dp = new int[nums.length + 1];
		int[] dp = new int[nums.length];
		//初始化：由递推公式，递推基础是dp[0]、dp[1]
//		dp[1] = nums[0];
//		dp[2] = Math.max(nums[0],nums[1]);
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0],nums[1]);

		//dp[i] 是根据dp[i - 2] 和 dp[i - 1] 推导出来的，那么一定是从前到后遍历！
//		for (int i = 3; i <= nums.length; i++) {
		for (int i = 2; i < nums.length; i++) {
//			dp[i] = Math.max(dp[i - 2] + nums[i - 1],dp[i - 1]);
			dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
		}


		return dp[nums.length - 1];
//		return dp[nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
