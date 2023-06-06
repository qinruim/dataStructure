package leetcode.editor.cn;

/**
 * 二叉树的最大深度
 * @author qr
 * @date 2023-06-07 00:18:28
 */
public class P104_MaximumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
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
    public int maxDepth(TreeNode root) {
		//递归三部曲1  确定参数和返回值
		int height = getHeight(root);

		return height;
    }

	private int getHeight(TreeNode root) {
		//2.终止条件
		if (root == null){return 0;}

		//3.单层递归逻辑
		//左右中  后序遍历  根节点高度即树的最大深度
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		int height = 1 + Math.max(leftHeight,rightHeight);

		return height;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
