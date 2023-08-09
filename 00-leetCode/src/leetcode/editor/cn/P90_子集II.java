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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<Integer> subset = new LinkedList<>();
		int startIndex = 0;

		Arrays.sort(nums);
		getSunsets(nums,startIndex,result,subset);

		return result;


    }

	private void getSunsets(int[] nums, int startIndex, List<List<Integer>> result, LinkedList<Integer> subset) {
		result.add(new ArrayList<>(subset));

		if (startIndex >= nums.length){
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			//树层去重  即跳过同一层用过的元素,即i>startIndex(遍历到该层后面的元素出现了重复)
			if (i > startIndex && nums[i] == nums[i -1]){
				continue;
			}

			subset.addLast(nums[i]);
			getSunsets(nums,i + 1,result,subset);
			subset.removeLast();

		}


	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
