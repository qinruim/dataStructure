package leetcode.editor.cn;

import java.util.Map;

/**
 * 二叉搜索树的最近公共祖先
 * lowest-common-ancestor-of-a-binary-search-tree
 * @author mqinrui
 * @date 2023-09-06 16:08:56
 */
class P235_LowestCommonAncestorOfABinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P235_LowestCommonAncestorOfABinarySearchTree().new Solution();
	 }
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);

        return traversal(root,val1,val2);
    }

    private TreeNode traversal(TreeNode root, int val1, int val2) {
        if (root == null){
            return null;
        }

        if (val2 < root.val){
            //去左子树找
            return traversal(root.left,val1,val2);
        }
        if (val1 > root.val){
            //去右子树找
            return traversal(root.right,val1,val2);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
