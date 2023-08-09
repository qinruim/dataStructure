package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * subsets
 * @author mqinrui
 * @date 2023-08-09 16:38:21
 */
class P78_Subsets{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P78_Subsets().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> result = new ArrayList<>();
	LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {


		int startIndex = 0;
		backTracking(nums,startIndex);
		return result;
    }

	private void backTracking(int[] nums, int startIndex) {
		result.add(new ArrayList<>(path));//每个节点都要加入结果  跟组合问题不同
		if (startIndex >= nums.length){
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			path.addLast(nums[i]);
			backTracking(nums,i + 1);
			path.removeLast();

		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
