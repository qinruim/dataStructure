package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最长递增子序列
 * longest-increasing-subsequence
 * @author mqinrui
 * @date 2023-08-24 15:48:29
 */
class P300_LongestIncreasingSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		int res = 0;
		//dp[i]:以nums[i]结尾的最长递增子序列长度
		int[] dp = new int[len];
		//初始值（以 nums[i] 结尾的最长递增子序列起码要包含它自己）
		Arrays.fill(dp,1);

		for (int i = 0; i < len; i++) {
			// 寻找 nums[0..j-1] 中比 nums[i] 小的元素
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]){
					// 把 nums[i] 接在后面，即可形成长度为 dp[j] + 1，
					// 且以 nums[i] 为结尾的递增子序列
					dp[i] = Math.max(dp[j] + 1,dp[i]);
				}
			}
			res = Math.max(res,dp[i]);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
