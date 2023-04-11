package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * @author mqinrui
 * @date 2023-04-11 15:07:20
 */
public class P94_BinaryTreeInorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
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
    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        traversal(root,result);
//        return result;

        //迭代法
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root; //指向root
        //当栈为空，或cur遍历到最后 即 cur=null 终止
        while (cur != null || !stack.isEmpty()){
            //一路向左，入栈。到左孩子为空（叶子节点）为止
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //到 cur = null 了，开始弹出
            else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }

        }
        return result;
    }

//    private void traversal(TreeNode root, List<Integer> result) {
//        if (root == null){
//            return;
//        }
//        //中序 左中右
//        traversal(root.left,result);
//        result.add(root.val);
//        traversal(root.right,result);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
