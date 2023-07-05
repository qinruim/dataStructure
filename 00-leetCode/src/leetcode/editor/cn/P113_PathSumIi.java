package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和 II
 * @author mqinrui
 * @date 2023-07-05 17:52:04
 */
 class TreeNode {
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

public class P113_PathSumIi {
    public static void main(String[] args) {
        //测试代码
//	 	 Solution solution = new P113_PathSumIi().new Solution();
        TreeNode node = new TreeNode(1, new TreeNode(3), new TreeNode(4));
        Solution solution = new Solution();
        solution.pathSum(node,4);
//         solution.pathSum()
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
    List<List<Integer>> result = new ArrayList<>();
//            List<Integer> path = new LinkedList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//		List<List<Integer>> result = new ArrayList<>();
////        List<Integer> path = new LinkedList<>();
//        List<Integer> path = new ArrayList<>();
        if (root == null){
			return result;
		}
//        getPathSum(root,targetSum,result,path);
        getPathSum(root,targetSum);
        System.out.println(result);
		return result;
    }

//    private void getPathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
    private void getPathSum(TreeNode root, int targetSum) {
        path.add(root.val);
        targetSum -= root.val;
        //终止条件  叶子节点
        if (root.left == null && root.right == null){
            //找到了和为targetSum的叶子
            if (targetSum == 0){
//                result.add(path);
                System.out.println(path);
//                System.out.println(result);

                result.add(new ArrayList<>(path));
            }
            //和不为targetSum的叶子
            return;
        }

        //单层递归
        if (root.left != null){
//            path.add(root.left.val);
//            getPathSum(root.left,targetSum,result,path);
            getPathSum(root.left,targetSum);
            //回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null){
//            path.add(root.left.val);
//            getPathSum(root.right,targetSum,result,path);
            getPathSum(root.right,targetSum);
            //回溯
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


