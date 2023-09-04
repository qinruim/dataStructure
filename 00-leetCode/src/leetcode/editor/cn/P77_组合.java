package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * combinations
 * @author mqinrui
 * @date 2023-08-04 10:57:38
 */
class P77_Combinations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P77_Combinations().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	LinkedList<List<Integer>> res = new LinkedList<>();
	LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {

		backTrack(n,k,1);
		return res;
}

	private void backTrack(int n, int k, int startIndex) {
		if (track.size() == k){
			res.add(new LinkedList<>(track));
			return;
		}

		for (int i = startIndex; i <= n; i++) {
			track.add(i);
			backTrack(n,k,i + 1);
			track.removeLast();
		}



	}

	}
//leetcode submit region end(Prohibit modification and deletion)


}
