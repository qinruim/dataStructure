package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * @author mqinrui
 * @date 2023-06-09 21:15:58
 */
public class P257_BinaryTreePaths{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P257_BinaryTreePaths().new Solution();
	 }

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

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
    public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();  //存放最终结果
		List<Integer> paths = new ArrayList<>();  //记录路径

		if (root == null){return null;}

		traversal(root,paths,result);
		return result;
    }

	private void traversal(TreeNode root, List<Integer> paths, List<String> result) {
		//前序遍历
		paths.add(root.val);
		//遇到叶子节点（终止条件） 输出路径
		if (root.left == null && root.right == null){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < paths.size() - 1; i++) {
				sb.append(paths.get(i)).append("->");
			}
			sb.append(paths.get(paths.size() - 1)); //记录
			result.add(sb.toString());
			return;
		}

		//递归 + 回溯  同时进行
		if (root.left != null){
			traversal(root.left,paths,result);  //递归
			paths.remove(paths.size() - 1);        //回溯
		}
		if (root.right != null){
			traversal(root.right,paths,result);  //递归
			paths.remove(paths.size() - 1);        //回溯
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
