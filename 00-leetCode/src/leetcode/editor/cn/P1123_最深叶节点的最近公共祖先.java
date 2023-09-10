package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 最深叶节点的最近公共祖先
 * lowest-common-ancestor-of-deepest-leaves
 * @author mqinrui
 * @date 2023-09-06 15:03:00
 */
class P1123_LowestCommonAncestorOfDeepestLeaves{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1123_LowestCommonAncestorOfDeepestLeaves().new Solution();
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
    Map<TreeNode,Integer> map = new HashMap<>();
    int depth = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {

       return traversal(root).getKey();
    }

    private Pair<TreeNode, Integer> traversal(TreeNode root) {
        if (root == null){
           return new Pair<>(null,0);
        }

        Pair<TreeNode,Integer> left = traversal(root.left);
        Pair<TreeNode,Integer> right = traversal(root.right);

        if (left.getValue() > right.getValue()){
            return new Pair<>(left.getKey(),left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()){
            return new Pair<>(right.getKey(),right.getValue() + 1);
        }
        return new Pair<>(root,right.getValue() + 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}
