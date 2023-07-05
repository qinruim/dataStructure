package leetcode.editor.cn;

/**
 * 完全二叉树的节点个数
 * @author qr
 * @date 2023-06-08 22:48:43
 */
public class P222_CountCompleteTreeNodes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P222_CountCompleteTreeNodes().new Solution();
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
    public int countNodes(TreeNode root) {
		//后序遍历 传统二叉树通解
//		return getNum(root);

		//利用完全二叉树的特征  除开最后一层，节点数为 2的n次方 - 1
		//终止条件2个  1.节点为空 2.子树为满二叉树（往下递归的时候总会到满二叉树）
		return getNum2(root);
    }

	private int getNum2(TreeNode root) {
		//终止条件1
		if (root == null){
			return 0;
		}
		//终止条件2
		TreeNode left = root.left;
		TreeNode right = root.right;
		int leftDepth = 0;
		int rightDepth = 0;
		while (left != null){
			left = left.left;
			leftDepth++;
		}
		while (right != null){
			right = right.right;
			rightDepth++;
		}
		// 根据左深度和右深度是否相同来判断该子树是不是满二叉树
		//满二叉树按照公式求节点数
		if (leftDepth == rightDepth){
			//二进制左移1位  相当于2^2
			return (2 << leftDepth) - 1;
		}

		//单层递归逻辑
		int leftNum = getNum2(root.left);
		int rightNum = getNum2(root.right);

		return leftNum + rightNum + 1;
	}

	private int getNum(TreeNode root) {
		if (root == null){
			return 0;
		}

		int leftNum = getNum(root.left);
		int rightNum = getNum(root.right);
		int result = leftNum + rightNum + 1;

		return result;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
