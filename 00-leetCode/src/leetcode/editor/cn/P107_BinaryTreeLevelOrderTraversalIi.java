package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历 II
 * @author mqinrui
 * @date 2023-04-18 16:33:49
 */
public class P107_BinaryTreeLevelOrderTraversalIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
    //利用LinkedList，进行头部插入
    public LinkedList<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		levelOrderBottom1(root);

		return res;
    }

	/**
	 * 迭代法  与102一样，区别在于结果数组用了：LinkedList，进行头部插入，得到自底向上的res
     * 注：List默认的add方法是尾插
	 * @param root
	 */
	private void levelOrderBottom1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null){
            deque.offer(root);
        }
        while (!deque.isEmpty()){
            //size控制每一层的元素
            int size = deque.size();
            List<Integer> list = new ArrayList<>();

            while (size-- > 0){
                TreeNode node = deque.pop();
                list.add(node.val);
                if (node.left != null){
                    deque.offer(node.left);
                }
                if (node.right != null){
                    deque.offer(node.right);
                }
            }
            // 新遍历到的层插到头部, 这样就满足按照层次反序的要求
            res.addFirst(list);
        }

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
