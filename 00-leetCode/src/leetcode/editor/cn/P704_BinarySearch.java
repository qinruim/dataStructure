//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics 数组 二分查找 👍 1192 👎 0


package leetcode.editor.cn;

/**
 * 二分查找
 * @author mqinrui
 * @date 2023-03-06 10:35:27
 */
public class P704_BinarySearch{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P704_BinarySearch().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
		/**
		 *二分法
		 * 使用[]  注意
		 * 1.while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
		 * 2.if (nums[middle] > target) right 要赋值为 middle - 1，
		 * 因为当前这个nums[middle]一定不是target，那么接下来要查找的左区间结束下标位置就是 middle - 1
		 */
		if (target < nums[0] || target > nums[nums.length - 1]){
			return -1;
		}
		int left = 0,right = nums.length - 1;
		while (left <= right){
			//用移位代理除法，避免整数溢出
			int mid = left + ((right - left) >> 1);
			if (nums[mid] == target){
				return mid;
			}
			else if (nums[mid] > target){
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
  		return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
