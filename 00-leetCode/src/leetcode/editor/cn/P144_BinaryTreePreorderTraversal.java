package leetcode.editor.cn;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * @author mqinrui
 * @date 2023-04-11 15:06:55
 */
public class P144_BinaryTreePreorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P144_BinaryTreePreorderTraversal().new Solution();
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
    public List<Integer> preorderTraversal(TreeNode root) {
//		List<Integer> result = new ArrayList<>();
//		traversal(root,result);
//		return result;

        //迭代法
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        //前序 中左右  入栈顺序 中右左
        //中间先入栈 然后弹出加入result，然后右孩子先入栈，左孩子后入栈；直至最后全部出栈
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            //中
            result.add(node.val);
            //右，左，为空不入栈
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }

//	private void traversal(TreeNode root, List<Integer> list) {
//		//终止条件
//		if (root == null){return;}
//		//单层递归逻辑 前序 中 左 右
//		list.add(root.val);
//		traversal(root.left,list);
//		traversal(root.right,list);
//	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
