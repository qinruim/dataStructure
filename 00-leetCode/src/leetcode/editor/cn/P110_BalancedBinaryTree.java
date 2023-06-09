package leetcode.editor.cn;

/**
 * 平衡二叉树
 * @author mqinrui
 * @date 2023-06-09 19:13:48
 */
public class P110_BalancedBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P110_BalancedBinaryTree().new Solution();
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
    public boolean isBalanced(TreeNode root) {
		int height = getHeight(root);

		return height == -1 ? false : true;

    }

	private int getHeight(TreeNode root) {
		if (root == null){
			return 0;
		}
		// 每个节点 的左右两个子树的高度差的绝对值不超过 1
		//如果内部某个节点已经不平衡 返回-1
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if (leftHeight == -1){return -1;}
		if (rightHeight == -1){return -1;}

		int result;
		if (Math.abs(leftHeight - rightHeight) > 1){
			result = -1;
		}
		else {
			result = 1 + Math.max(leftHeight,rightHeight);
		}
		return result;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
