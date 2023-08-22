package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 打家劫舍 II
 * house-robber-ii
 * @author mqinrui
 * @date 2023-08-21 22:31:25
 */
class P213_HouseRobberIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P213_HouseRobberIi().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
		//数组成环  分别考虑两种情况：不包含最后一个元素    不包含第一个元素
		//每种情况都跟不成环的打家劫舍一样
		if (nums.length == 0){
			return 0;
		}
		if (nums.length == 1){
			return nums[0];
		}

		int res1 = robWithoutElement(nums,0,nums.length - 2);
		int res2 = robWithoutElement(nums,1,nums.length - 1);

		return Math.max(res1,res2);
    }


	private int robWithoutElement(int[] nums, int beginIndex, int endIndex) {
		int[] numbers = Arrays.copyOfRange(nums,beginIndex,endIndex+1);
		for (int number : numbers) {
			System.out.print(number + "\t");
		}
		System.out.println("\t");

//		if (numbers.length == 0){
//			return 0;
//		}
//		if (numbers.length == 1){
//			return numbers[0];
//		}
		if (beginIndex == endIndex){
			return nums[beginIndex];
		}
		int[] dp = new int[numbers.length];
		dp[0] = numbers[0];
		dp[1] = Math.max(numbers[0],numbers[1]);

		for (int i = 2; i < numbers.length; i++) {
			dp[i] = Math.max(dp[i - 1],dp[i - 2] + numbers[i]);
		}

		return dp[numbers.length - 1];
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
