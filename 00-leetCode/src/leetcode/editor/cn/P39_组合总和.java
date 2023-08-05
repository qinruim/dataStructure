package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 * combination-sum
 * @author mqinrui
 * @date 2023-08-05 11:04:45
 */
class P39_CombinationSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P39_CombinationSum().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	ArrayList<List<Integer>> result = new ArrayList<>();
	LinkedList<Integer> combine = new LinkedList<>();
//	int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

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

		//剪枝，startIndex++ ： 每一层，往后遍历一个元素就将前面元素排除，防治集合重复
		for (int i = startIndex; i < candidates.length; i++,startIndex++) {
			target -= candidates[i];
			combine.addLast(candidates[i]);
			backTracking(candidates,target, startIndex);
			combine.removeLast();
			target += candidates[i];
		}





	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
