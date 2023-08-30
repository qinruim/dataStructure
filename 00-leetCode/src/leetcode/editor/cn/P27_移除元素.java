package leetcode.editor.cn;

/**
 * 移除元素
 * remove-element
 * @author mqinrui
 * @date 2023-08-30 10:44:45
 */
class P27_RemoveElement{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P27_RemoveElement().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
		int slow = 0;
		for (int fast = 0; fast < nums.length; fast++) {
			if (nums[fast] != val){
				nums[slow++] = nums[fast];
			}
		}

		return slow;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
