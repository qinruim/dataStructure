package leetcode.editor.cn;

import java.util.ArrayList;
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

	/**
	 * 1.确定参数
	 */
	LinkedList<Integer> path = new LinkedList<>();
	//还需要一个二维的，结果集
	List<List<Integer>> result = new ArrayList<>();
	//还需要传入n、k   以及一个startIndex，用来记录这个参数用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）
	int startIndex = 1;


    public List<List<Integer>> combine(int n, int k) {
		backTracking(n,k,startIndex);
		return result;
}

	private void backTracking(int n, int k, int startIndex) {
		/**
		 * 2.确定终止条件
		 */
		//到叶子节点（叶子就是路径），即要的结果
		//path的大小为k的时候，即找到了一个组合
		if (path.size() == k){
//			result.add(path); //这样打印出来为空，因为相当于将result尾部指向了path地址，后续path内容的变化会导致res的变化
			result.add(new ArrayList<>(path));//相当于开辟一个独立地址，地址中存放的内容为path链表，后续path的变化不会影响到res
			return;
		}


		/**
		 * 3.单层搜索逻辑
		 */
		//从startIndex开始,每个节点做一个for循环，遍历剩余元素，将路径记录下来

		//剪枝优化 已经有了path.size个元素，还需要k-path.size个，那么在n个元素的集合中，
		//最多从 n - (k- path.size()) + 1 开始（左闭）
		//再往后就不够了

		for (int i = startIndex; i <= n - (k- path.size()) + 1; i++){
			//单层搜索
//			path.add(i);
			path.add(i);
			//递归
			backTracking(n,k,i + 1);
			//回溯
//			path.remove(((Integer) i));
			path.removeLast();
		}

	}

	}
//leetcode submit region end(Prohibit modification and deletion)


}
