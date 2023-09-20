package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 所有可能的路径
 * all-paths-from-source-to-target
 * @author mqinrui
 * @date 2023-09-20 15:59:43
 */
class P797_AllPathsFromSourceToTarget{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P797_AllPathsFromSourceToTarget().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 LinkedList<Integer> onPath = new LinkedList<>();
		 List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		traverse(graph,0);
		return res;
    }

	private void traverse(int[][] graph,int cur){
		onPath.addLast(cur);

		if (cur == graph.length - 1){
			res.add(new ArrayList<>(onPath));
			onPath.removeLast();
			return;
		}
		int[] neighbors = graph[cur];
		if (neighbors.length == 0){
			onPath.removeLast();
			return;
		}
		for (int neighbor : neighbors) {
			traverse(graph,neighbor);
		}
		onPath.removeLast();

	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
