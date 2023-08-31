package leetcode.editor.cn;

/**
 * 二叉树的直径
 * diameter-of-binary-tree
 * @author mqinrui
 * @date 2023-08-31 14:17:42
 */
class P543_DiameterOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P543_DiameterOfBinaryTree().new Solution();
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
	int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
		//直径 = 左右子树最大深度之和

		//获取节点的最大深度
		getMaxDepth(root);
		return res;
    }


	private int getMaxDepth(TreeNode root) {
		if (root == null){
			return 0;
		}

		int lDepth = getMaxDepth(root.left);
		int rDepth = getMaxDepth(root.right);
		//后序位置顺便更新最大直径（这里能获得子树的最大深度）
		res = Math.max(res,lDepth + rDepth);

		return Math.max(lDepth,rDepth) + 1;
	}


}
//leetcode submit region end(Prohibit modification and deletion)


}
