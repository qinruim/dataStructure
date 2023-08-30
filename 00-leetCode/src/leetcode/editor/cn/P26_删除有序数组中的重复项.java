package leetcode.editor.cn;

/**
 * 删除有序数组中的重复项
 * remove-duplicates-from-sorted-array
 * @author mqinrui
 * @date 2023-08-30 10:05:26
 */
class P26_RemoveDuplicatesFromSortedArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P26_RemoveDuplicatesFromSortedArray().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
		if (nums.length == 0){
			return 0;
		}

		int slow = 0;

		for (int fast = 0; fast < nums.length; fast++) {
			if (nums[fast] != nums[slow]){
//				slow++;
				nums[++slow] = nums[fast];
			}
		}

		return slow + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
