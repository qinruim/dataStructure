//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1596 👎 0


package leetcode.editor.cn;

import java.util.jar.JarEntry;

/**
 * 长度最小的子数组
 * @author mqinrui
 * @date 2023-03-06 11:46:08
 */
public class P209_MinimumSizeSubarraySum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P209_MinimumSizeSubarraySum().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
		/**
		 * 滑动窗口
		 */
		//i个元素之和
		int sum = 0;
		int subLength = 0;
		int start = 0;
//		int result = Integer.MAX_VALUE;
		int result = nums.length;
		//end是滑动窗口结束位置 将之向后滑动
		for (int end = 0; end < nums.length; end++) {
			sum += nums[end];
			//注意这里使用while，每次更新 start（起始位置），并不断比较子序列是否符合条件
			while (sum >= target){
				//记录子数组长度 更新result
				subLength = end - start + 1;
				result = Math.min(result,subLength);
				//移动
				sum = sum - nums[start];
				start++;
			}
		}
//		return result == Integer.MAX_VALUE ? 0 : result;
		return result == nums.length ? 0 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
