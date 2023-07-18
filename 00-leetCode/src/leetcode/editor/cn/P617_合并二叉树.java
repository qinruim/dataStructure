package leetcode.editor.cn;

/**
 * 合并二叉树
 * merge-two-binary-trees
 * @author mqinrui
 * @date 2023-07-18 09:34:25
 */
class P617_MergeTwoBinaryTrees{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P617_MergeTwoBinaryTrees().new Solution();
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
	/**
	 * 同时遍历两个二叉树 对应节点相加为新节点值  返回新二叉树
	 * @param root1
	 * @param root2
	 * @return
	 */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		return getNewRoot(root1,root2);
    }

	private TreeNode getNewRoot(TreeNode root1, TreeNode root2) {
		//终止条件
		if (root1 == null){
			return root2;
		}
		if (root2 == null){
			return root1;
		}

		//单层递归逻辑(重复利用root1即可)
		root1.val += root2.val;

		//递归
		root1.left = getNewRoot(root1.left,root2.left);
		root1.right = getNewRoot(root1.right,root2.right);

		return root1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
