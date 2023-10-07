package leetcode.editor.cn;

import java.util.Stack;

/**
 * 下一个更大元素 II
 * next-greater-element-ii
 * @author mqinrui
 * @date 2023-09-27 16:39:39
 */
class P503_NextGreaterElementIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P503_NextGreaterElementIi().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;;
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 2 * n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i % n] >= stack.peek()){
				stack.pop();
			}
			res[i % n] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums[i % n]);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
