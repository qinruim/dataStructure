package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * @author mqinrui
 * @date 2023-04-11 15:07:13
 */
public class P145_BinaryTreePostorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P145_BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal(TreeNode root) {
        //递归
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
		return result;



    }

    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        //后序 左右中
        traversal(root.left,result);
        traversal(root.right,result);
        result.add(root.val);




    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
