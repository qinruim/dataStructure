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
	ArrayList<List<Integer>> result = new ArrayList<>();
	LinkedList<Integer> combine = new LinkedList<>();

	boolean[] used;


	/**
	 * 注意树层和树枝去重
	 * @param candidates
	 * @param target
	 * @return
	 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		used = new boolean[candidates.length];
		backTracking(candidates,target,0);
		return result;
    }

	private void backTracking(int[] candidates, int target, int startIndex) {
		if (target < 0){
			return;
		}
		if (target == 0){
			result.add(new ArrayList<>(combine));
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {

			//使用used数组
			//树层去重 即used[i-1]回溯了，是false，且nums[i] == nums[i-1],剪枝
//			if (i > 0 && !used[i -1] && candidates[i] == candidates[i - 1]){
//				continue;
//			}

			//用startIndex去重，跳过同一层用过的元素
			// 即i>startIndex时，说明同一层开始遍历后面的元素，当重复，即跳过
			if (i > startIndex && candidates[i] == candidates[i - 1]){
				continue;
			}

//			used[i] = true;
			target -= candidates[i];
			combine.addLast(candidates[i]);
			backTracking(candidates,target,i + 1);
			combine.removeLast();
			target += candidates[i];
//			used[i] = false;

		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
