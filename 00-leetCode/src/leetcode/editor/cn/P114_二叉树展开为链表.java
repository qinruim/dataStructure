package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树展开为链表
 * flatten-binary-tree-to-linked-list
 * @author mqinrui
 * @date 2023-08-31 15:37:52
 */
class P114_FlattenBinaryTreeToLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P114_FlattenBinaryTreeToLinkedList().new Solution();
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
class Solution {
    /**
     * 用一个list把前序遍历结果装起来  再挨个改指针
     */
    LinkedList<TreeNode> list = new LinkedList<>();
    public void flatten(TreeNode root) {
        //1.暴力
//        traversal(root);
//        while (!list.isEmpty()){
//            TreeNode node1 = list.pollFirst();
//            node1.right = list.peekFirst();
//            node1.left = null;
//        }

        //2.在遍历是直接改指针
        traversal2(root);



    }

    TreeNode pre = null;
    private void traversal2(TreeNode root) {
        if (root == null){return;}

        traversal2(root.right);
        traversal2(root.left);

        root.right = pre;
        root.left = null;
        pre = root;
    }




    private void traversal(TreeNode root) {
        if (root == null){
            return;
        }

        list.addLast(root);
       traversal(root.left);
        traversal(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
