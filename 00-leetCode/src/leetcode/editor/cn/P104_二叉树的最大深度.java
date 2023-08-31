package leetcode.editor.cn;

/**
 * 二叉树的最大深度
 * maximum-depth-of-binary-tree
 * @author mqinrui
 * @date 2023-08-31 10:56:37
 */
class P104_MaximumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
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
	int res = 0;//记录最大深度
	int depth = 0;//记录到达节点的深度

    public int maxDepth(TreeNode root) {
		//遍历框架
//		traverse(root);
//		return res;

		//分解问题思路 子树深度的最大值 + 1
		return getMaxDepth(root);
    }

	private int getMaxDepth(TreeNode root) {
		if (root == null){
			return 0;
		}
		int leftMax = getMaxDepth(root.left);
		int rightMax = getMaxDepth(root.right);

		//后序位置
		int res = Math.max(leftMax,rightMax) + 1;
		return res;

//		return Math.max(getMaxDepth(root.left),getMaxDepth(root.right)) + 1;

	}

	private void traverse(TreeNode root) {
		if (root == null){
			return;
		}
		//前序位置
		depth++;
		if (root.left == null && root.right == null){
			//叶子节点 更新最大深度
			res = Math.max(res,depth);
		}

		traverse(root.left);
		traverse(root.right);

		//后序位置
		depth--;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
