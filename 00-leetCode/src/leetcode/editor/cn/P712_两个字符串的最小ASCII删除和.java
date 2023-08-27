package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 两个字符串的最小ASCII删除和
 *
 * @author qr
 * @date 2023-08-27 22:11:25
 */
class P712_MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P712_MinimumAsciiDeleteSumForTwoStrings().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * ascii最小，那肯定是在lcs中 找删除ascii最小的那个
         */
        int[][] memo;
        public int minimumDeleteSum(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            memo = new int[len1][len2];
            for (int[] row : memo) {
                Arrays.fill(row,-1);
            }

            //s1[i,..] 和 s2[j,...] 相等 需要删除的ascii最小和
           return dp(s1,0,s2,0);
        }

        private int dp(String s1, int i, String s2, int j) {
            int res = 0;

            //有一个字符串到头了，另一个剩下的都要删除
//
            if (i == s1.length()) {
                // 如果 s1 到头了，那么 s2 剩下的都得删除
                for (; j < s2.length(); j++)
                    res += s2.charAt(j);
                return res;
            }
            if (j == s2.length()) {
                // 如果 s2 到头了，那么 s1 剩下的都得删除
                for (; i < s1.length(); i++)
                    res += s1.charAt(i);
                return res;
            }

            if (memo[i][j] != -1) {
                return memo[i][j];
            }

            //两个字符相同 都不删除
            if (s1.charAt(i) == s2.charAt(j)){
                memo[i][j] = dp(s1,i + 1,s2,j + 1);
            }else {
                //至少一个不用删
                memo[i][j] = Math.min(
                        dp(s1,i + 1,s2,j) + s1.charAt(i),  //删除s1[i]
                        dp(s1,i,s2,j + 1) + s2.charAt(j) //删除s2[j]
                );

            }

            return memo[i][j];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
