package leetcode.editor.cn;

/**
 * 打家劫舍 III
 * house-robber-iii
 * @author mqinrui
 * @date 2023-08-21 23:05:18
 */
class P337_HouseRobberIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P337_HouseRobberIii().new Solution();
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
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 树形dp入门题
         * @param root
         * @return
         */
        public int rob(TreeNode root) {
            //dp[0]不偷、dp[1]偷当前节点能获得的最大金钱
            //每个节点用一个dp数组表示，递归过程中，系统栈会保存每层节点的dp数组

            //result就是dp数组，表示的是根节点偷或不偷的情况
            // result[0]:不偷根节点  result[1]:偷根节点的最大金额
            int[] result = robTree(root);
            return Math.max(result[0],result[1]);
        }

        /**
         * 计算偷或者不偷当前节点能获得的最大金额的递归函数
         * 用一个dp数组保存两种情况并返回
         * @param cur
         * @return
         */
        private int[] robTree(TreeNode cur) {
            int[] curDp = new int[2];
            //终止条件 当前节点为null 返回空数组
            if (cur == null){
                return curDp;
            }

            //总的是后序遍历的顺序,因为处理当前节点需要用到左右子树的结果
            //递归左右子树
            int[] leftDp = robTree(cur.left);
            int[] rightDp = robTree(cur.right);

            //偷当前节点的金额(不能偷左右孩子)
            int value1 = cur.val + leftDp[0] + rightDp[0];
            //不偷当前节点(左右孩子偷不偷由哪个大决定)
            int value2 = Math.max(leftDp[0],leftDp[1]) + Math.max(rightDp[0],rightDp[1]);

            curDp[0] = value2;
            curDp[1] = value1;
            return curDp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
