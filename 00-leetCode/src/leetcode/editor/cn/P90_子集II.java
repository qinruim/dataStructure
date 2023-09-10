package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 * subsets-ii
 * @author mqinrui
 * @date 2023-08-09 17:04:49
 */
class P90_SubsetsIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P90_SubsetsIi().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 LinkedList<List<Integer>> res = new LinkedList<>();
		 LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		//排序 给相邻树枝中的相同元素剪枝去重
		Arrays.sort(nums);
		backTrack(nums,0);
		return res;
    }

	private void backTrack(int[] nums, int startIndex) {
		res.add(new LinkedList<>(track));

		for (int i = startIndex; i < nums.length; i++) {
			if (i > startIndex && nums[i] == nums[i - 1]){
				continue;
			}
			track.add(nums[i]);
			backTrack(nums,i + 1);
			track.removeLast();
		}

	}



}
//leetcode submit region end(Prohibit modification and deletion)


}
