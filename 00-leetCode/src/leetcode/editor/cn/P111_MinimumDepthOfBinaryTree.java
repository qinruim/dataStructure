package leetcode.editor.cn;

/**
 * 二叉树的最小深度
 * @author qr
 * @date 2023-06-07 00:58:40
 */
public class P111_MinimumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
	 }

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {

		return getMinHeight(root);
    }

	private int getMinHeight(TreeNode root) {
		if (root == null){return 0;}

		int leftMinHeight = getMinHeight(root.left);
		int rightMinHeight = getMinHeight(root.right);


		//注意与求最大深度的区别   当有一个子树为空时，应该取不为空的最小高度
		// （因为最小深度是从根节点到最近叶子节点的最短路径上的节点数量）
		if (root.left == null) {
			return rightMinHeight + 1;
		}
		if (root.right == null) {
			return leftMinHeight + 1;
		}
		// 左右结点都不为null
		return 1+ Math.min(leftMinHeight, rightMinHeight);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
