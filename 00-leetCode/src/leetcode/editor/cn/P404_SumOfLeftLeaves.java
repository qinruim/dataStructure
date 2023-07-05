package leetcode.editor.cn;

/**
 * 左叶子之和
 * @author mqinrui
 * @date 2023-06-29 10:09:32
 */
public class P404_SumOfLeftLeaves{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P404_SumOfLeftLeaves().new Solution();
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
    public int sumOfLeftLeaves(TreeNode root) {
        //终止条件 两个 第二个终止条件可以不写，作用是减少了递归层数
		if (root == null) return 0; //空节点
        if (root.left == null && root.right == null) return 0; //叶子节点返回0  在叶子节点的父节点才收集其left（左叶子）

        //单层递归逻辑 后序遍历
		int leftValue = sumOfLeftLeaves(root.left); //左子树左叶子节点和    左
        //收集当前root的左叶子节点值（处理当前左子树是叶子节点的情况）
        if (root.left != null && root.left.left == null && root.left.right == null){
            leftValue = root.left.val;
        }
        int rightValue = sumOfLeftLeaves(root.right);                  //右

        return leftValue + rightValue;                                  //中
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
