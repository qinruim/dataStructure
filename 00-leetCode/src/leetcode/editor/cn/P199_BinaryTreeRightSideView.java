package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * @author mqinrui
 * @date 2023-04-18 17:40:58
 */
public class P199_BinaryTreeRightSideView{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P199_BinaryTreeRightSideView().new Solution();
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
	public List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
		getRightView(root);
		return result;
    }

	/**
	 * 层序遍历的时候，判断是否遍历到单层的最后面的元素，如果是，就放进result数组中，随后返回result就可以了
	 * @param root
	 */
	private void getRightView(TreeNode root) {
		if (root == null){
			return;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);

		//一次循环是一层
		while (!deque.isEmpty()){
			int size = deque.size();

			//遍历除这一层的所有元素
			while (size > 0){
				TreeNode tmpNode = deque.poll();
				//遍历到该层最后一个节点，即最右边的节点，加入result
				if (size == 1){
					result.add(tmpNode.val);
				}
				if (tmpNode.left != null){
					deque.offer(tmpNode.left);
				}
				if (tmpNode.right != null){
					deque.offer(tmpNode.right);
				}
				size--;
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
