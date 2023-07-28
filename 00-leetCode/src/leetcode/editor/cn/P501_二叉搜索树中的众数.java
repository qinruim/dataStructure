package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉搜索树中的众数
 * find-mode-in-binary-search-tree
 * @author mqinrui
 * @date 2023-07-28 10:34:53
 */
class P501_FindModeInBinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P501_FindModeInBinarySearchTree().new Solution();
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
	 * 个人思路：中序遍历二叉树放入map并记录次数，再遍历map得到众数
	 */
	class Solution {
    public int[] findMode(TreeNode root) {
		Map<Integer,Integer> map = new HashMap<>();
		traversal(root,map);
		List<Integer> resList = new ArrayList<>();
//		int[] res = new int[map.size()];

		int maxCount = 0;
		for (Integer value : map.values()) {
			maxCount = value > maxCount ? value : maxCount;
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == maxCount){
				resList.add(entry.getKey());
			}
		}

		/**
		 * resList 是一个 List<Integer> 类型的列表，它包含了一些整数元素。
		 *
		 * resList.stream() 将 resList 转换为一个 Stream<Integer> 对象，这样我们就可以使用 Stream API 提供的各种中间操作和终端操作。
		 *
		 * mapToInt 是一个中间操作，它将 Stream<Integer> 中的每个元素转换为 int 类型。这里使用方法引用 Integer::valueOf 将每个 Integer 对象转换为对应的原始 int 值。
		 *
		 * toArray() 是一个终端操作，它将 Stream<Integer> 中的元素收集到一个原始的 int 数组中。
		 */
		return resList.stream().mapToInt(Integer::valueOf).toArray();

    }

		private void traversal(TreeNode root, Map<Integer, Integer> map) {
			if (root == null){
				return;
			}
			traversal(root.left,map);
			map.put(root.val,map.getOrDefault(root.val,0)+1);
			traversal(root.right,map);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)


}
