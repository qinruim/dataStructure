package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最小绝对差
 * minimum-absolute-difference-in-bst
 * @author mqinrui
 * @date 2023-07-28 09:50:45
 */
class P530_MinimumAbsoluteDifferenceInBst{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P530_MinimumAbsoluteDifferenceInBst().new Solution();
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


	/**
	 * 个人思路：中序遍历，然后比较相邻两个节点的差值，取最小值
	 */
	class Solution {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
		 //中序遍历
        getMidder(root,list);
        for (int i = 1; i < list.size(); i++) {
            if((list.get(i) - list.get(i - 1)) < min){
                min = list.get(i) - list.get(i - 1);
            }
        }
        return min;
        }

        private void getMidder(TreeNode root, List<Integer> list) {
            if (root == null){
                return;
            }
            getMidder(root.left,list);
            list.add(root.val);
            getMidder(root.right,list);
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


}
