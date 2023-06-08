package leetcode.editor.cn;

/**
 * 二叉搜索树中的搜索
 * @author qr
 * @date 2023-06-09 00:34:56
 */
public class P700_SearchInABinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P700_SearchInABinarySearchTree().new Solution();
	 }
	public class TreeNode {
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
    public TreeNode searchBST(TreeNode root, int val) {
		TreeNode targetRoot = getTargetRoot(root,val);

		return targetRoot;
    }

	private TreeNode getTargetRoot(TreeNode root, int val) {
//		if (root == null){
//			return null;
//		}
//		if (root.val == val){
//			return root;
//		}
		if (root == null || root.val == val){
			return root;
		}

		//因为二叉搜索树的节点是有序的，所以可以有方向的去搜索。
		// 如果root->val > val，搜索左子树，如果root->val < val，就搜索右子树
		// root->val == val，已经在终止条件排除
		// 最后如果都没有搜索到，就返回NULL
		if (root.val > val){
			return getTargetRoot(root.left,val);
		}
		else {
			return getTargetRoot(root.right,val);
		}

//		TreeNode leftTargetRoot = getTargetRoot(root.left, val);
//		TreeNode rightTargetRoot = getTargetRoot(root.right, val);
//
//		return leftTargetRoot == null ? rightTargetRoot : leftTargetRoot;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
