package leetcode.editor.cn;

import java.util.*;

/**
 * 两数之和
 * two-sum
 * @author mqinrui
 * @date 2023-09-06 14:41:58
 */
class P1_TwoSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1_TwoSum().new Solution();
		  int[] nums = {3,3};
		  solution.twoSum(nums,6);
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
		//1.两层for
		//2.二叉树 递归
		return method2(nums,target);
    }

	private int[] method2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int need = target - nums[i];
			if (map.containsKey(need)){
				res[0] = i;
				res[1] = map.get(need);
				break;
			}
			map.put(nums[i],i);
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
