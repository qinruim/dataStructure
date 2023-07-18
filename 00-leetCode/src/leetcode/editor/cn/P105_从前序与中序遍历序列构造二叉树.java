package leetcode.editor.cn;

/**
 * 从前序与中序遍历序列构造二叉树
 * construct-binary-tree-from-preorder-and-inorder-traversal
 * @author mqinrui
 * @date 2023-07-17 16:10:25
 */
class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {


		//左闭右开
		return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);

    }

	private TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
		//不满足左闭右开 说明没有元素 返回空树
		if (preBegin >= preEnd || inBegin >= inEnd){
			return null;
		}

		//前序数组的第一个元素就是根节点元素
		int rootValue = preorder[preBegin];
		TreeNode root = new TreeNode(rootValue);

		//获取中间结点在中序数组中的位置（切割点）
		int index;
		for (index = 0; index < inorder.length; index++) {
			if (inorder[index] == rootValue){
				break;
			}
		}

		//切割中序数组 左闭右开
		int leftInBegin = inBegin;
		int leftInEnd = index;
		int rightInBegin = index + 1;
		int rightInEnd = inEnd;

		//切割前序数组 左闭右开
		int leftPreBegin = preBegin + 1;
		int leftPreEnd = leftPreBegin + (leftInEnd - leftInBegin);// 终止位置是起始位置加上中序左区间的大小size
		int rightPreBegin = leftPreEnd;
		int rightPreEnd = preEnd;


		root.left = findNode(preorder,leftPreBegin,leftPreEnd,inorder,leftInBegin,leftInEnd);
		root.right = findNode(preorder,rightPreBegin,rightPreEnd,inorder,rightInBegin,rightInEnd);

		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
