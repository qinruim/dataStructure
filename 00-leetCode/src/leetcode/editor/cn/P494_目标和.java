package leetcode.editor.cn;

/**
 * 目标和
 * target-sum
 * @author mqinrui
 * @date 2023-08-16 22:33:46
 */
class P494_TargetSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P494_TargetSum().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 分成两个子集合 一个加法的集合（记为left） 一个减法的（记为right）
	 * 让两个集合之差 等于 target：
	 * 	left + right = sum （nums元素和）
	 * 	left - right = target
	 * 	==> left = (target + sum) / 2  是一个确定的数 （背包大小）
	 * 	如果不能整除 就是找不出这样的集合， return 0
	 * 	如果target的绝对值已经大于sum，那么也是没有方案的。
	 *
	 *
	 * 	 即在nums中找出若干个元素 装满背包left,
	 * 	 装满背包的方式 有多少种，就是题目要求的表达式数目
	 *
	 * @param nums
	 * @param target
	 * @return
	 */

	int count = 0;
	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if ((target + sum) % 2 != 0 || Math.abs(target) > sum){
			return 0;
		}

		int bagSize = (target + sum) / 2;

		//1.一维动规
//		return dp1(nums,bagSize);
		//2.二维动规
//		return dp2(nums,bagSize);
		//3.回溯
//		int count = 0;
		backTrack(nums,target,0);
		return count;
    }

	/**
	 * 回溯
	 * @param nums
	 * @param target 目标
	 * @param startIndex
	 * @return
	 */
	private void backTrack(int[] nums, int target, int startIndex) {
		if (startIndex == nums.length){
			if (target == 0){
				count++;
			}
			return;

		}

		//回溯：
		//1.+
		target -= nums[startIndex];
		backTrack(nums,target,startIndex + 1);
		target += nums[startIndex];
		//2.-
		target += nums[startIndex];
		backTrack(nums,target,startIndex+1);
		target -= nums[startIndex];


//		return 0;
	}


	/**
	 * 一维动规
	 *  由二维 dp[i][j] 只跟 dp[i-1][] 有关  可以压缩
	 * @param nums
	 * @param bagSize
	 * @return
	 */
	private int dp1(int[] nums, int bagSize) {
		//装满容量j的方法有dp[j]种
		int[] dp = new int[bagSize + 1];
		//递推公式：只要搞到nums[i]，凑成dp[j]就有dp[j - nums[i]] 种方法。
		//初始化
		dp[0] = 1;

		for (int i = 0; i < nums.length; i++) {
			for (int j = bagSize; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}
		return dp[bagSize];
	}


	/**
	 * 2.二维动规
	 * @param nums
	 * @param bagSize
	 * @return
	 */
	private int dp2(int[] nums, int bagSize) {
		int n = nums.length;

		//dp[i][j]:前i个数，凑出bagSize 的方法数
		int[][] dp = new int[n + 1][bagSize + 1];

		//base case
//		for (int i = 0; i < n; i++) {
//			dp[i][0] = 1;
//			//dp[0][j] = 0;
//		}
		//这里不能向上面这样初始化，是因为本题 nums 数组中的元素是可能为 0 的，
		// 那么背包容量为 0 时，「什么都不装」可能就不是唯一的装法了，需要去计算
		//因此下面 j从0开始计算
		dp[0][0] = 1;

		//遍历
		for (int i = 1; i <= n ; i++) {
			for (int j = 0; j <= bagSize; j++) {
				if (j < nums[i - 1]){
					//装不下
					dp[i][j] = dp[i - 1][j];
				}else {
					//能装下 装或不装
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
				}
			}
		}

		return dp[n][bagSize];
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
