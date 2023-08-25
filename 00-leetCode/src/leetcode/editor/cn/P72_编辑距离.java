package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 编辑距离
 * edit-distance
 *
 * @author mqinrui
 * @date 2023-08-23 16:31:46
 */
class P72_EditDistance {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P72_EditDistance().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minDistance(String word1, String word2) {
            int res;
            int len1 = word1.length();
            int len2 = word2.length();
            //1.原始暴力解法
//		res = getMin(len1 - 1,len2 - 1,word1,word2);

            //2.带备忘录的递归
            int[][] memo = new int[len1][len2];
            //初始化特殊值，表示还未计算
            for (int[] row : memo) {
                Arrays.fill(row,-1);
            }
//		    res = getMemoMin(len1 - 1,len2 - 1,word1,word2,memo);

            //3.自底向上的迭代解法（动规）
            res = getMinDis(len1, len2, word1, word2);


            return res;
        }


        /**
         * 原始暴力递归解法
         * getMin(i,j):返回word1[0...i]和word2[0...j]两个字符串的最小操作数
         * 其中i、j为指向两个字符串最后一个元素的指针
         *
         * @param i
         * @param j
         * @param word1
         * @param word2
         * @return
         */
        private int getMin(int i, int j, String word1, String word2) {
            if (i == -1) {
                return j + 1;
            }
            if (j == -1) {
                return i + 1;
            }

            //两个指针指向元素相同，啥也不做，都向前移
            if (word1.charAt(i) == word2.charAt(j)) {
                return getMin(i - 1, j - 1, word1, word2);
            }
            //不同，则有三种可能的操作，取最小的
            else {
                return min(
                        getMin(i, j - 1, word1, word2) + 1, //插入
                        getMin(i - 1, j, word1, word2) + 1,   //删除
                        getMin(i - 1, j - 1, word1, word2) + 1  //替换
                );
            }
        }

        /**
         * 带备忘录的递归，
         * <p>
         * 在暴力递归的基础上加一个备忘录记录计算的每一个值
         *
         * @param i
         * @param j
         * @param word1
         * @param word2
         * @param memo
         * @return
         */
        private int getMemoMin(int i, int j, String word1, String word2, int[][] memo) {

            if (i == -1) {
                return j + 1;
            }
            if (j == -1) {
                return i + 1;
            }

            //查备忘录
            if (memo[i][j] != -1) {
                return memo[i][j];
            }


            //两个指针指向元素相同，啥也不做，都向前移
            if (word1.charAt(i) == word2.charAt(j)) {
//			return getMin(i - 1,j - 1,word1,word2);
                memo[i][j] = getMemoMin(i - 1, j - 1, word1, word2, memo);
            }
            //不同，则有三种可能的操作，取最小的
            else {
//			return min(
//					getMin(i,j - 1,word1,word2) + 1, //插入
//					getMin(i - 1,j,word1,word2) + 1,   //删除
//					getMin(i - 1,j - 1,word1,word2) + 1  //替换
//			);
                memo[i][j] = min(
                        getMin(i, j - 1, word1, word2) + 1, //插入
                        getMin(i - 1, j, word1, word2) + 1,   //删除
                        getMin(i - 1, j - 1, word1, word2) + 1  //替换
                );
            }

            return memo[i][j];
        }


        /**
         * 自底向上 迭代（动规）
         *
         * @param len1
         * @param len2
         * @param word1
         * @param word2
         * @return
         */
        private int getMinDis(int len1, int len2, String word1, String word2) {
            //dp[i][j]:存储word1[0....i-1]变成word2[0....j-1]的最小编辑距离
            int[][] dp = new int[len1 + 1][len2 + 1];

            for (int i = 1; i <= len1; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= len2; j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + 1
                        );
                    }

                }

            }


            return dp[len1][len2];
        }

        private int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
