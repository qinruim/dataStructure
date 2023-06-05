package leetcode.editor.cn;

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

    /**
     * 定义二叉树节点ss
     */
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
//        List<Integer> result = new ArrayList<>();
//        traversal(root, result);
//        return result;

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

    /**
     *  1.确定递归函数的参数和返回值： 要打印前序遍历的各节点值，因此传入TreeNode对象存放节点；
     *                           传入结果List 存放结果值
     *                          此外不需要处理数据、不需要返回值；因此函数返回值是void
     * @param root
     * @param list
     */
//    private void traversal(TreeNode root, List<Integer> list) {
//        /**
//         *  2.确定终止条件:当前遍历节点为空说明到叶子节点了，本层递归终止
//         *    所以如果当前遍历的这个节点是空，就直接return，终止递归
//         */
//        if (root == null){return;}
//
//
//        /**
//         * 3. 确定单层递归逻辑 前序 中 左 右
//         */
//        list.add(root.val);
//        traversal(root.left,list);
//        traversal(root.right,list);
//    }

//
//    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
