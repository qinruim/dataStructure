package leetcode.editor.cn;

/**
 * 最大子数组和
 * @author qr
 * @date 2023-08-27 17:44:32
 */
class P53_MaximumSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P53_MaximumSubarray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
		int res;
		//1.滑动窗口
//		res = slipWindow(nums);


		//2.动态规划
		res = dpRes(nums);

		return res;
    }

	/**
	 * 动态规划
	 * @param nums
	 * @return
	 */
	private int dpRes(int[] nums) {
		int len = nums.length;

		//dp[i] ； 以nums[i]结尾的最大子数组和
		int[] dp = new int[len];

		dp[0] = nums[0];

		for (int i = 1; i < len; i++) {
			dp[i] = Math.max(nums[i],dp[i - 1] + nums[i]);
		}

		int res = Integer.MIN_VALUE;
		for (int e : dp) {
			System.out.print(e + "\t");
			res = Math.max(res,e);
		}
		return res;
	}

	/**
	 * 滑动窗口：
	 *
	 *  在窗口内和>=0时缩小窗口
	 *  在窗口内和<0时扩大窗口
	 *  在移动窗口时更新值
	 *
	 * @param nums
	 * @return
	 */
	private int slipWindow(int[] nums) {
		int left = 0,right = 0;
		int windowSum = 0;
		int maxSum = Integer.MIN_VALUE;

		while (right < nums.length){
			//扩大窗口并更新答案
			windowSum += nums[right];
			right++;
			maxSum = Math.max(windowSum,maxSum);

			//判断窗口是否需要收缩
			while (windowSum < 0){
				windowSum -= nums[left];
				left++;
			}
		}

		return maxSum;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
