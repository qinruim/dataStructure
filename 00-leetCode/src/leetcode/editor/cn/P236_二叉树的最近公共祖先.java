package leetcode.editor.cn;

/**
 * 二叉树的最近公共祖先
 * lowest-common-ancestor-of-a-binary-tree
 * @author mqinrui
 * @date 2023-07-28 11:06:42
 */
class P236_LowestCommonAncestorOfABinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P236_LowestCommonAncestorOfABinaryTree().new Solution();
	 }
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

	/**
	 *  x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
	 *  思路:从下往上处理，交汇点就是公共祖先——后序遍历（天然回溯）
	 *  	判断左子树是否出现了p或q，右子树是否出线p或q，若是，那么当前节点就是公共祖先
	 *
	 *  注意二叉搜索树里没有重复元素，且一定包含p、q，所以下面代码包含了某个节点本身就是公共祖先的情况
	 */
	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null){
				return null;
			}

			//前序位置
			if (root == p || root == q){
				return root;
			}

			TreeNode left = lowestCommonAncestor(root.left,p,q);
			TreeNode right = lowestCommonAncestor(root.right,p,q);

			//后序位置
			if (left == null && right == null){
				return null;
			}
			if (left != null && right!= null){
				return root;
			}
			return left == null ? right : left;


 		}
	}
//leetcode submit region end(Prohibit modification and deletion)


}
