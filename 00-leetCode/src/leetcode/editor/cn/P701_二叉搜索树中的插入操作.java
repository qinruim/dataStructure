package leetcode.editor.cn;

/**
 * 二叉搜索树中的插入操作
 * insert-into-a-binary-search-tree
 * @author mqinrui
 * @date 2023-08-02 23:19:20
 */
class P701_InsertIntoABinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P701_InsertIntoABinarySearchTree().new Solution();
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

//不用考虑调整二叉树结构，按照二叉搜索树的规则去遍历，插入即可
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
		//终止条件
		if (root == null){
			//将要插入的节点返回给上一层，完成父子节点赋值操作
			TreeNode node = new TreeNode(val);
			return node;
		}

		//单层递归逻辑（BST不需要遍历整棵树，根据val的大小决定递归方向）
		//下一层将新加入的节点返回，本层用root.right 或者 root.left 接住  完成父子节点赋值
		if (val > root.val){
			root.right = insertIntoBST(root.right,val);
		}
		if (val < root.val){
			root.left = insertIntoBST(root.left,val);
		}


		return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
