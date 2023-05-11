package leetcode.editor.cn;

/**
 * 翻转二叉树
 * @author mqinrui
 * @date 2023-05-11 09:29:47
 */
public class P226_InvertBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P226_InvertBinaryTree().new Solution();
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

		/**
		 * 前后序遍历都可以
		 * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），
		 * 再右孩子交换孩子（此时其实是对原来的左孩子做交换）
		 */

		//1.确定递归参数和返回值
		//2.确定终止条件
		if (root == null){
			return root;
		}
		//3.确定单层递归逻辑
		//交换左右孩子(前序遍历)
		swap(root);
		invertTree(root.left);
		invertTree(root.right);

		return root;
    }

	private void swap(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
