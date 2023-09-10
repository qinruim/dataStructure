package leetcode.editor.cn;

import java.util.*;

/**
 * 组合总和 II
 * combination-sum-ii
 * @author mqinrui
 * @date 2023-08-05 12:04:52
 */
class P40_CombinationSumIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P40_CombinationSumIi().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	LinkedList<List<Integer>> res = new LinkedList<>();
	LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		backTrack(candidates,target,0);
		return res;
    }

	private void backTrack(int[] candidates, int target, int startIndex) {
		if (target < 0){
			return;
		}
		if (target == 0){
			res.add(new LinkedList<>(track));
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {
			if (i > startIndex && candidates[i] == candidates[i - 1]){
				continue;
			}
			track.add(candidates[i]);
			target -= candidates[i];
			backTrack(candidates,target,i + 1);
			target += candidates[i];
			track.removeLast();
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
