package leetcode.editor.cn;

import java.util.*;

/**
 * 杀掉进程
 * kill-process
 * @author mqinrui
 * @date 2023-09-19 17:19:09
 */
class P582_KillProcess{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P582_KillProcess().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		//先把题目输入的这棵树转化成常规形式（父节点指向子节点），
		// 然后执行遍历算法（DFS/BFS 都可以）去遍历删除以目标节点 kill 为根的整棵子树
		//构建多叉树 key为父节点 value为一个链表，存储所有子节点
		Map<Integer,List<Integer>> tree = new HashMap<>();
		for (int i = 0; i < pid.size(); i++) {
			int child = pid.get(i);
			int parent = ppid.get(i);
			tree.putIfAbsent(parent,new ArrayList<>());
			tree.get(parent).add(child);
		}

		LinkedList<Integer> res = new LinkedList<>();
		//遍历多叉树
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(kill);
		while (!queue.isEmpty()){
			int cur = queue.poll();
			res.add(cur);
			if (tree.containsKey(cur)){
				queue.addAll(tree.get(cur));
			}

		}
		return res;




    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
