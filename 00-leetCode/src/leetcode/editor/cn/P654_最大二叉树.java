package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最大二叉树
 * maximum-binary-tree
 * @author mqinrui
 * @date 2023-07-17 16:46:09
 */
class P654_MaximumBinaryTree{

	public static void main(String[] args) {
	 	 //测试代码
		 Solution solution = new P654_MaximumBinaryTree().new Solution();
		 int[] nums = {3, 2, 1, 6, 0, 5};
		 solution.constructMaximumBinaryTree(nums);
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //终止条件
        //输入数组长度 >=1   因此长度为1时就遍历到叶子节点了
        if (nums.length == 1){
           TreeNode node = new TreeNode(nums[0]);
           return node;
        }

        //单层递归逻辑
        //1.找到根节点及其下标，下标用来分割数组
        int rootValue = Arrays.stream(nums).max().getAsInt();
//		System.out.println(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int rootIndex;
        for (rootIndex = 0; rootIndex < nums.length; rootIndex++) {
            if (rootValue == nums[rootIndex]){
                break;
            }
        }

        //2.以最大值rootValue为分界点，分割左右数组，用来递归构造左右子树
        //要保证分割的区间至少存在一个元素
        int[] leftNums = new int[rootIndex];
        int[] rightNums = new int[nums.length - leftNums.length - 1]; //去掉分界点
//        for (int i = 0; i < nums.length; i++) {
//            if (i < rootIndex){
//                leftNums[i] = nums[i];
//            }else if (i > rootIndex){
//                rightNums[i - rootIndex - 1] = nums[i];
//            }
//        } //这种方法分割的数组包括空数组 会出错

        //分割左数组并递归
        if (rootIndex > 0){
//            int[] leftNums = new int[rootIndex];
            for (int i = 0; i < rootIndex; i++) {
                if (i < rootIndex){
                    leftNums[i] = nums[i];
                }
            }
            root.left = constructMaximumBinaryTree(leftNums);
        }
        //分割右数组并递归
        if (rootIndex < (nums.length - 1)){
            for (int i = rootIndex + 1; i < nums.length; i++) {
                rightNums[i - rootIndex - 1] = nums[i];
            }
            root.right = constructMaximumBinaryTree(rightNums);
        }
		return root;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}
