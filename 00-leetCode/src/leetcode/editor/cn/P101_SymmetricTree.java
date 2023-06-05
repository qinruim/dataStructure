package leetcode.editor.cn;

/**
 * 对称二叉树
 * @author qr
 * @date 2023-06-06 00:21:31
 */
public class P101_SymmetricTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P101_SymmetricTree().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
		/**
		 * 轴对称
		 * 要比较的是根节点的左子树与右子树是不是相互翻转的
		 */
		return compare(root.left,root.right);
    }

	private boolean compare(TreeNode left, TreeNode right) {
		//1.看传入的左右节点是否对称
		if (left == null && right != null){return false;}
		if (left != null && right == null){return false;}
		if (left == null && right == null){return true;}

		if (left.val != right.val){return false;}

		//2.还剩 left.val == right.val；比较内外侧节点，进入递归
		//比较外侧、内侧
		boolean outSide = compare(left.left,right.right);
		boolean inSide = compare(left.right,right.left);

		//当内、外侧都相同，该点的左右子树才对称
		return outSide && inSide;

	}
}


//leetcode submit region end(Prohibit modification and deletion)

}
