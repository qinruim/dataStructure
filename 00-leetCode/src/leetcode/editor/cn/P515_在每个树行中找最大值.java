package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 * find-largest-value-in-each-tree-row
 * @author mqinrui
 * @date 2023-08-31 15:02:06
 */
class P515_FindLargestValueInEachTreeRow{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P515_FindLargestValueInEachTreeRow().new Solution();
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
    public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null){
			return res;
		}
		//层序遍历 记录每一行的最大值 并加入res
		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()){
			int size = queue.size();

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				max = Math.max(max,cur.val);

				if (cur.left != null){
					queue.offer(cur.left);
				}
				if (cur.right != null){
					queue.offer(cur.right);
				}

			}
			res.add(max);
		}

		return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
