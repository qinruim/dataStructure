package leetcode.editor.cn;

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
	LinkedList<List<Integer>> res = new LinkedList<>();
	LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {

		backTrack(nums,0);
		return res;

    }

	private void backTrack(int[] nums, int startIndex) {
		//for循环会终止  这里不需要显示写base case
//		if (track.size() > nums.length){
//			return;
//		}

		//前序位置
		res.add(new LinkedList<>(track));

		//通过startIndex控制树枝 避免重复
		for (int i = startIndex; i < nums.length; i++) {
			track.add(nums[i]);
			backTrack(nums,i + 1);
			track.removeLast();
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
