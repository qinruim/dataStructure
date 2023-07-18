package leetcode.editor.cn;

import java.util.ArrayList;

/**
 * 验证二叉搜索树
 * validate-binary-search-tree
 * @author mqinrui
 * @date 2023-07-18 10:07:23
 */
class P98_ValidateBinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P98_ValidateBinarySearchTree().new Solution();
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
	/**
	 * 中序遍历下，输出的二叉搜索树节点的数值是有序序列。
	 * 有了这个特性，验证二叉搜索树，就相当于变成了判断一个序列是不是递增的了
	 */
	class Solution {
    public boolean isValidBST(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		//中序遍历二叉树转为数组（单调增）
		getRootArray(root,list);
		Integer[] rootArray = list.toArray(new Integer[list.size()]);
		for (int i = 1; i < rootArray.length; i++) {
			if (rootArray[i] <= rootArray[i - 1]){
				return false;
			}
		}
		return true;
    }

		private void getRootArray(TreeNode root, ArrayList<Integer> list) {
			//终止条件
			if (root == null) return;
			getRootArray(root.left,list);
			list.add(root.val);
			getRootArray(root.right,list);
		}


	}
//leetcode submit region end(Prohibit modification and deletion)


}
