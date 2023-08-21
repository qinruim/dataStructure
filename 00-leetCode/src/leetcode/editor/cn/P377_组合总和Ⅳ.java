package leetcode.editor.cn;

/**
 * 组合总和 Ⅳ
 * combination-sum-iv
 * @author mqinrui
 * @date 2023-08-21 11:10:38
 */
class P377_CombinationSumIv{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P377_CombinationSumIv().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int combinationSum4(int[] nums, int target) {

		int[] dp = new int[target + 1];

		dp[0] = 1;

		//求排列 应该外层遍历背包
		for (int j = 0; j <= target ; j++) {
			for (int i = 0; i < nums.length; i++) {
				//外层遍历背包从容量0开始，这里显式判断容量要比元素重量大
				if (j - nums[i] >= 0){
					dp[j] += dp[j - nums[i]];
				}
			}
		}

		for (int i : dp) {
			System.out.print(i+"\t");
		}

		return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
