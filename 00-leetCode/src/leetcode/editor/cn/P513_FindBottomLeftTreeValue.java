package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 * @author mqinrui
 * @date 2023-07-03 09:07:16
 */
public class P513_FindBottomLeftTreeValue{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P513_FindBottomLeftTreeValue().new Solution();
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
    public int findBottomLeftValue(TreeNode root) {
		//层序遍历  记录最后一行第一个数即可
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		int result = 0;
		while (!queue.isEmpty()){
			int size = queue.size();
			int temp = queue.size();
			//遍历一层
			while (size > 0){
				TreeNode poll = queue.poll();
				//记录每行第一个元素值，遍历结束，就是最后一行的第一个元素值，即左下角元素
				if (size == temp){
					result = poll.val;
				}
				//将取出节点的孩子加入队列
				if (poll.left != null) {
					queue.offer(poll.left);
				}
				if (poll.right != null) {
					queue.offer(poll.right);
				}
				size--;
			}
		}

		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
