package leetcode.editor.cn;

import java.util.List;

/**
 * N 叉树的最大深度
 * @author qr
 * @date 2023-06-07 00:51:50
 */
public class P559_MaximumDepthOfNAryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P559_MaximumDepthOfNAryTree().new Solution();
	 }

	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
		// 见104 二叉树的最大深度 逻辑一样

		return getHeight(root);

	}

	private int getHeight(Node root) {
		if (root == null){return 0;}
		int childHeight = 0;
		for (int i = 0; i < root.children.size(); i++) {
			childHeight = Math.max(childHeight,getHeight(root.children.get(i)));
		}

		return 1 + childHeight;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
