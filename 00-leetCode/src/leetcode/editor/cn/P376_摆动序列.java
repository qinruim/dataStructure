package leetcode.editor.cn;

/**
 * 摆动序列
 * wiggle-subsequence
 * @author mqinrui
 * @date 2023-08-08 17:30:28
 */
class P376_WiggleSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P376_WiggleSubsequence().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 个人思路：回溯 先拿到差值数组 回溯遍历所有子序列 检验子序列是否摆动序列 是则跟当前最大长度比较 更新最大长度
	 * 缺点：超时
	 *
	 * 卡尔：贪心 或者 动态规划
	 * @param nums
	 * @return
	 */
	public int wiggleMaxLength(int[] nums) {

		int result;

		//回溯
//		result = backTracking(nums, 0, 0, 0);

		//贪心
		result = greedy(nums);

		//动态规划
//		result = dp(nums);

		return result;
	}


	private int greedy(int[] nums) {
		/**
		 * 贪心思路：遇到峰/谷就记录，遇到平缓就跳过
		 * 				峰：当前值大于前一个值，且大于后一个值
		 * 				谷：当前值小于前一个值，且小于后一个值
		 * 				平缓：当前值等于前一个值，或者等于后一个值
		 * 				用preDiff = nums[i] - nums[i - 1] 记录当前值与前一个差值
		 * 				  curDiff = nums[i + 1] - nums[i] 记录后一个值与当前差值
		 * 				  如果 preDiff * curDiff < 0 （异号）说明是峰/谷，否则是平缓
		 *
		 * 				注意：第一个值和最后一个值默认是峰/谷，因此从第二个值开始遍历到倒数第二个元素，结果+2
		 * 			 		若相邻两个值相等，跳过
		 *
		 *
		 */
		if (nums.length <= 1){
			return nums.length;
		}
		if (nums.length == 2){
			return nums[0] == nums[1] ? 1 : 2;
		}

		//nums.length >= 3
		int result = 1; //默认最右边有一个摆动 遍历到倒数第二个元素
		int preDiff = 0;
		int curDiff;
//		int flag = 0;
		for (int i = 0; i < nums.length - 1; i++) {
//			preDiff = nums[i] - nums[i - 1];
			curDiff = nums[i + 1] - nums[i];
//			curDiff = nums[i] - nums[i -1];
			//峰/谷   平阶段首部记录，尾部跳过 共一个
			if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)){
				result++;
				preDiff = curDiff;//只在摆动变化的时候更新prediff
			}

		}
		return result;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
