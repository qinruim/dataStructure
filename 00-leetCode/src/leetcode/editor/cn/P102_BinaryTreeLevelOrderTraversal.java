package leetcode.editor.cn;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历 相当于图论的广度优先搜索
 * @author mqinrui
 * @date 2023-04-18 10:13:17
 */
public class P102_BinaryTreeLevelOrderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();
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
	public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
		//迭代法
//		levelorder1(root);
		//递归法
		levelorder2(root,0);
		return res;
    }

	/**
	 * 递归法
	 * @param node
	 * @param deep
	 */
	private void levelorder2(TreeNode node, Integer deep) {
//		//到叶子节点跳出到上一层递归
//		if (node == null){
//			return;
//		}
//		//node！=null 时往下递归，递归深度（二叉树层级）++
//		deep++;
//
//		//层级增加，当前层的节点增加，res的每一项是一个存放了一层元素的数组，因此用res的索引来界定层级
//		//这个判断条件保证每一层只新建一个list加入res，因为后面要递归两次（左右子树）；否则每一层会新建双倍的空list加入res
//		if (res.size() < deep){
//			//存放当前层的节点
//			List<Integer> currentLevelList = new ArrayList<>();
//			//将存放当前层节点元素的数组加入结果二维数组
//			res.add(currentLevelList);
//		}
//		//将 deep-1 层元素放入 currentLevelList 数组
//		res.get(deep - 1).add(node.val);
//
//		//递归左右子树
//		levelorder2(node.left,deep);
//		levelorder2(node.right,deep);

		if(node == null){return;}

		//deep = 0
		if (res.size() <= deep){
			ArrayList<Integer> currentLevelList = new ArrayList<>();
			res.add(currentLevelList);
		}

		//当前层元素加入current
		res.get(deep).add(node.val);

		deep++;
		levelorder2(node.left,deep);
		levelorder2(node.right,deep);
	}

	/**
	 * 迭代法
	 * @param root
	 */
	private void levelorder1(TreeNode root) {
		Deque<TreeNode> deque = new LinkedList<>();
		//根节点加入队列
		if (root != null){
			deque.offer(root);
		}
		//遍历队列中的元素
		while (!deque.isEmpty()){
			//记录本层元素个数，控制每一层的元素，保证后面全部遍历出来
			int size = deque.size();
			//存储某一层的元素
			List<Integer> list = new ArrayList<>();

			//取出队列中的节点 用size控制本层元素，遍历本层元素，同时将下一层元素加入队列
			while (size-- > 0){
				TreeNode node =  deque.pop();
				//记录本层节点,即把本层元素放到一维数组里
				list.add(node.val);

				//将取出节点的孩子节点加入队列
				if (node.left != null){
					deque.offer(node.left);
				}
				if (node.right != null){
					deque.offer(node.right);
				}
			}
			//一层遍历完，将这一层结果加入result
			res.add(list);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
