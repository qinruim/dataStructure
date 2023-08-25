package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 下降路径最小和
 * minimum-falling-path-sum
 *
 * @author mqinrui
 * @date 2023-08-24 17:05:22
 */
class P931_MinimumFallingPathSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P931_MinimumFallingPathSum().new Solution();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int res = solution.minFallingPathSum(matrix);
        System.out.println(res);
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int res = Integer.MAX_VALUE;


            //1.暴力递归穷举  终点可能是最后一行的任意一列
//            for (int j = 0; j < n; j++) {
//                res = Math.min(res, getMin(matrix, n - 1, j));
//            }

            //2.加备忘录的递归
//            memo = new int[n][n];
//            for (int[] row : memo) {
//                Arrays.fill(row, Integer.MAX_VALUE);
//            }
//            for (int j = 0; j < n; j++) {
//                res = Math.min(res, getMemoMin(matrix, n - 1, j));
//            }

            //3.自底向上（动规）
            res = getDP(matrix);

            return res;
        }




        /**
         * 暴力递归
         * getMin（i,j） 获取到点（i,j）的最小路径
         *
         * @param matrix
         * @param i
         * @param j
         * @return
         */
        private int getMin(int[][] matrix, int i, int j) {
            //非法索引检查
            if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
                //返回一个特殊值
                return Integer.MAX_VALUE;
            }

            //base case  递归到第一行 返回本身的值
            if (i == 0) {
                return matrix[i][j];
            }

            //状态转移 (i,j)来自（i-1,j-1）(i-1,j)(i-1,j+1)
            return matrix[i][j] + min(
                    getMin(matrix, i - 1, j - 1),
                    getMin(matrix, i - 1, j),
                    getMin(matrix, i - 1, j + 1)
            );
        }

        /**
         * 带备忘录递归
         *
         * @param matrix
         * @param i
         * @param j
         * @return
         */
        private int getMemoMin(int[][] matrix, int i, int j) {
            //非法索引检查
            if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
                //返回一个特殊值
                return Integer.MAX_VALUE;
            }

            //base case  递归到第一行 返回本身的值
            if (i == 0) {
                return matrix[i][j];
            }

            //查找备忘录
            if (memo[i][j] != Integer.MAX_VALUE){
                return memo[i][j];
            }

            //状态转移 (i,j)来自（i-1,j-1）(i-1,j)(i-1,j+1)
            memo[i][j] = matrix[i][j] + min(
                    getMin(matrix, i - 1, j - 1),
                    getMin(matrix, i - 1, j),
                    getMin(matrix, i - 1, j + 1)
            );

            return memo[i][j];
        }

        /**
         * 自底向上  动态规划
         *
         * @param matrix
         * @return
         */
        private int getDP(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                dp[0][i] = matrix[0][i];
//                dp[1][i] = 1;
            }
//            for (int i = 0; i <= n; i++) {
//                dp[i][0] = Integer.MAX_VALUE;
//            }



            for (int r =  1; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    //最后一列
                    if (c >= n - 1){
                        dp[r][c] = matrix[r][c] + Math.min(dp[r - 1][c],dp[r - 1][c - 1]);
                    }
                    //第一列
                    else if (c < 1){
                        dp[r][c] = matrix[r][c] + Math.min(dp[r - 1][c],dp[r - 1][c + 1]);
                    }else {
                        dp[r][c] = matrix[r][c] + min(
                                dp[r - 1][c - 1],
                                dp[r - 1][c],
                                dp[r - 1][c + 1]
                        );
                    }
                }

            }

            for (int[] row : dp) {
                for (int i = 0; i < row.length; i++) {
                    System.out.print(row[i] + "\t");
                }
                System.out.println("\t");
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n ; i++) {
                res = Math.min(res,dp[n - 1][i]);
            }
            return res;
        }
        private int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}
