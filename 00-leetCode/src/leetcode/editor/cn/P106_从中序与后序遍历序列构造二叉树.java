package leetcode.editor.cn;

/**
 * 从中序与后序遍历序列构造二叉树
 * construct-binary-tree-from-inorder-and-postorder-traversal
 * @author mqinrui
 * @date 2023-07-06 09:21:55
 */
class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal{

	public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /**
         * 终止条件
          */
		//1.后序数组为空，那root为null
		if (postorder.length == 0){
			return null;
		}

		//2.后序数组的最后一个元素就是根节点元素
		int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        //后序数组只有一个元素，说明递归遍历到了叶子节点， 返回给上一层
        if (postorder.length == 1){
            return root;
        }

        /**
         * 单层递归逻辑
         */
        //切割点
        int index; //记录中间结点在中序的位置，定义在循环外边
        for (index = 0; index < inorder.length; index++) {
            //找到中间结点在中序的位置
            if (inorder[index] == rootValue){
                break;
            }
        }

        //切割时边界条件保持统一：左闭右开

        //切割中序数组 得到 左子树的中序数组 右子树的中序数组
        //[0,index) [index+1,inorder.length - 1)    index是中间结点在中序的位置
        int[] leftInorder = new int[index];
        int[] rightInorder = new int[inorder.length - leftInorder.length - 1];//不包括中间结点
        for (int i = 0; i < inorder.length; i++) {
            if (i < index){
                leftInorder[i] = inorder[i];
            }else if (i > index){
                rightInorder[i - index - 1] = inorder[i];
            }
        }

        //切割后序数组 得到 左子树的后序数组 右子树的后序数组
        //中序数组我们都切成了左中序数组和右中序数组了，
        //那么后序数组就可以按照左中序数组的大小来切割，切成左后序数组和右后序数组。
        //[0,leftInorder.length) [leftInorder.length,postorder.length - 1 - 1) //舍弃后序最后一个元素
        int[] leftPostorder = new int[leftInorder.length];
        int[] rightPostorder = new int[rightInorder.length];
        for (int i = 0; i < postorder.length - 1; i++) {
            if (i < leftPostorder.length){
                leftPostorder[i] = postorder[i];
            }else if (i >= leftPostorder.length){
                rightPostorder[i - leftPostorder.length] = postorder[i];
            }
        }



        //递归
        root.left = buildTree(leftInorder,leftPostorder);
        root.right = buildTree(rightInorder,rightPostorder);




		return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
