package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 III
 * combination-sum-iii
 * @author mqinrui
 * @date 2023-08-04 15:31:24
 */
class P216_CombinationSumIii{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P216_CombinationSumIii().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 List<List<Integer>> result = new ArrayList<>();
		 LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
		//思路：找出1到9里面，所有k个数的组合，判断这个组合之和是否等于n

		backTracking(n,k,1);
		return result;

    }

	private void backTracking(int n, int k, int startIndex) {
		if (path.size() == k){
			int count = 0;
			for (Integer integer : path) {
				count+=integer;
			}
			if (count == n){
				result.add(new ArrayList<>(path));
			}
			return;
		}

		for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++){
			path.addLast(i);
			backTracking(n,k,i + 1);
			path.removeLast();
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
