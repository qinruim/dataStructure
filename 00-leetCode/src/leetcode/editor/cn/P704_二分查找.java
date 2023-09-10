package leetcode.editor.cn;

/**
 * 二分查找
 * binary-search
 * @author mqinrui
 * @date 2023-09-06 11:12:00
 */
class P704_BinarySearch{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P704_BinarySearch().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right){
			int mid = left + (right - left) / 2;
			if (nums[mid] == target){
				return mid;
			}else if (nums[mid] < target){
				left = mid + 1;
			}else if (nums[mid] > target){
				right = mid - 1;
			}
		}

		return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
