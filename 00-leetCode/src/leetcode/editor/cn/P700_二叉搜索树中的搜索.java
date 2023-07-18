package leetcode.editor.cn;

/**
 * 二叉搜索树中的搜索
 * search-in-a-binary-search-tree
 * @author mqinrui
 * @date 2023-07-18 09:48:11
 */
class P700_SearchInABinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P700_SearchInABinarySearchTree().new Solution();
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
	public TreeNode searchBST(TreeNode root, int val) {
		return getTargetRoot(root,val);
	}

	private TreeNode getTargetRoot(TreeNode root, int val) {
		//终止条件
//		if (root == null){
//			return null;
//		}
//		if (root.val == val){
//			return root;
//		}
		if (root == null || root.val == val){
			return root;
		}

		//因为二叉搜索树的节点是有序的（左小右大），所以可以有方向的去搜索。
		// 如果root->val > val，搜索左子树，如果root->val < val，就搜索右子树
		// root->val == val，已经在终止条件排除
		// 最后如果都没有搜索到，就返回NULL
		if (root.val > val){
			return getTargetRoot(root.left,val);
		}
		else {
			return getTargetRoot(root.right,val);
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
