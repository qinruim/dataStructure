package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * populating-next-right-pointers-in-each-node
 * @author mqinrui
 * @date 2023-08-31 16:00:34
 */
class P116_PopulatingNextRightPointersInEachNode{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P116_PopulatingNextRightPointersInEachNode().new Solution();
	 }


	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
		//1.层序
//		return method1(root);

		//2.递归 抽象成三叉树遍历的方式
		if (root == null){
			return null;
		}
		traversal(root.left,root.right);
		return root;
    }

	private void traversal(Node left, Node right) {
		if (left == null || right == null){
			return;
		}

		//前序
		left.next = right;
		traversal(left.left,left.right);
		traversal(left.right,right.left);
		traversal(right.left,right.right);
	}


	/**
	 * 层序遍历
	 * @param root
	 * @return
	 */
	private Node method1(Node root) {
		if (root == null){
			return null;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		Node cur,pre;
		while (!queue.isEmpty()){
			int size = queue.size();
			pre = null;

			for (int i = 0; i < size; i++) {
				cur = queue.poll();
				if (cur.left != null){
					queue.offer(cur.left);
				}
				if (cur.right != null){
					queue.offer(cur.right);
				}
				//在每一层内维护一个pre 指向cur
				if (pre != null){
					pre.next = cur;
				}
				//更新pre
				pre = cur;
			}

			pre.next = null;

		}


		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
