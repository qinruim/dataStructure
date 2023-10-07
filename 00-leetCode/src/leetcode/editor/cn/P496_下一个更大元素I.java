package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素 I
 * next-greater-element-i
 * @author mqinrui
 * @date 2023-09-27 15:06:22
 */
class P496_NextGreaterElementI{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P496_NextGreaterElementI().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		//求 nums1 中的元素在 nums2 中的下一个更大元素
		//nums1 时 nums2 的子集

		//求出nums2的下一个更大元素集合存到map  遍历nums1去查map即可
		int n2 = nums2.length;
		//<元素，下一个比他大的元素>
		Map<Integer,Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = n2 - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums2[i] >= stack.peek()){
				stack.pop();
			}
			int nextMax = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums2[i]);
			map.put(nums2[i],nextMax);
		}

		int n1 = nums1.length;
		int[] res = new int[n1];
		for (int i = 0;i < n1;i++) {
			if (map.containsKey(nums1[i])){
				res[i] = map.get(nums1[i]);
			}
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
