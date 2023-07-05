package leetcode.editor.cn;

/**
 * 路径总和
 * @author mqinrui
 * @date 2023-07-04 17:32:02
 */
public class P112_PathSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P112_PathSum().new Solution();
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
		//递归一层，targetSum-节点值  到叶子为0 说明路径和为targetSum
		if (root == null){
			return false;
		}
		targetSum -= root.val;
		//终止条件 遇到叶子节点，且路径和为targetSum
		if (root.left == null && root.right == null){
			return targetSum == 0;
		}



		//单层递归逻辑 左、右    不需要处理中的逻辑  顺序  无所谓
		if (root.left != null){
//			targetSum -= root.left.val;
			if (hasPathSum(root.left,targetSum)) {return true;}
			//回溯 加回节点值
//			targetSum += root.left.val;
		}
		if (root.right != null){
//			targetSum -= root.right.val;
			if (hasPathSum(root.right,targetSum)) {return true;}
			//回溯 加回节点值
//			targetSum += root.right.val;
		}

		return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
