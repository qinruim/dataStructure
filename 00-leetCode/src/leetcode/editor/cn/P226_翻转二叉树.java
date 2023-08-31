package leetcode.editor.cn;

/**
 * 翻转二叉树
 * invert-binary-tree
 * @author mqinrui
 * @date 2023-08-31 15:13:50
 */
class P226_InvertBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P226_InvertBinaryTree().new Solution();
	 }

	private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//力扣代码提交区
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
    public TreeNode invertTree(TreeNode root) {
		//应该自顶向下依次交换左右孩子节点
		//前中后序没关系

		if (root == null){
			return null;
		}
		traverse(root);
		return root;
    }

	/**
	 * 输入一个节点 交换左右孩子
	 * @param root
	 */
	private void traverse(TreeNode root) {
		//注意 root==null一定要放在前面   否则 当root==null  会空指针
//		if (root == null || (root.left == null && root.right == null)){
//			return;
//		}
//
//		swap(root);
//		traverse(root.left);
//		traverse(root.right);

		if (root.left == null && root.right == null){
			return;
		}
		swap(root);
		if (root.left != null){
			traverse(root.left);
		}
		if (root.right != null){
			traverse(root.right);
		}
	}

	private void swap(TreeNode root) {
		//可能有一个孩子为null
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
