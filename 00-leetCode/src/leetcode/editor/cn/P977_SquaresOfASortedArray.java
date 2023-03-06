//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 736 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 有序数组的平方
 * @author mqinrui
 * @date 2023-03-06 11:13:15
 */
public class P977_SquaresOfASortedArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P977_SquaresOfASortedArray().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
		/**
		 * 双指针
		 * 数组是升序，两个指针分别放在两边比较大小逆序放入答案数组
		 *
		 * ***因为数组其实是有序的， 只不过负数平方之后可能成为最大数了。
		 * 那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
		 * 因此从数组两边开始平方，从新数组尾部开始放入
		 */
		int left = 0,right = nums.length - 1;
		int[] result = new int[nums.length];
		int k = result.length - 1;

		while (left <= right){
			int leftSquare = nums[left]*nums[left],rightSquare = nums[right]*nums[right];
			if (leftSquare < rightSquare){
				result[k] = rightSquare;
				right--;
			}
			else {
				result[k] = leftSquare;
				left++;
			}
			k--;
		}
		return result;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
