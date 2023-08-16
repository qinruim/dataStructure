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
	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if ((target + sum) % 2 != 0 || Math.abs(target) > sum){
			return 0;
		}

		int bagSize = (target + sum) / 2;

		return oneDimension(nums,bagSize);
//		return twoDimension(nums,bagSize);
    }



	private int oneDimension(int[] nums, int bagSize) {
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


	private int twoDimension(int[] nums, int bagSize) {

		//使用 下标为[0, i]的nums[i]能够凑满j（包括j）这么大容量的包，有dp[i][j]种方法。
		int[][] dp = new int[nums.length][bagSize + 1];
		//初始化
		// 初始化最上行（dp[0][j])，当nums[0] == j时
		// （注意nums[0]和j都一定是大于等于零的，因此不需要判断等于-j时的情况），
		// 有唯一一种取法可取到j，dp[0][j]此时等于1
		for (int j = 0; j <= bagSize; j++) {
			if (nums[0] == j){
				dp[0][j] = 1;
			}
		}

		return 0;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
