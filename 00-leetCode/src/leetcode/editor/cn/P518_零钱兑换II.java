package leetcode.editor.cn;

/**
 * 零钱兑换 II
 * coin-change-ii
 *
 * @author mqinrui
 * @date 2023-08-20 17:41:48
 */
class P518_CoinChangeIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P518_CoinChangeIi().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *先物品后背包的情况下，根据递推公式，dp【j】一定是来自于外层上一次的结果，
         * 而外层上一次的结果一定是来源于上一个物品的dp数组，所以不会出现物品2在物品1之前的情况，
         * 也就是只会出现【物品1，物品1，物品2】这种情况，而物品2不会出现在物品1之前，恰好对应组合问题；
         *
         * 而外层遍历背包内层遍历物品就不一样了，每一层的dp【j】都是在固定j的情况下，
         * 把物品从头开始遍历，所以dp【j】来自于上一层的结果，而上一层的结果又遍历了所有物品，
         * 所以这种遍历方式会出现【物品1，物品2，物品1】这种情况，恰好对应了排列问题
         *
         * @param amount
         * @param coins
         * @return
         */
        public int change(int amount, int[] coins) {
            //dp[j] ： 凑成总金额j的货币组合数为dp[j];所有的dp[j - coins[i]]（考虑coins[i]的情况）相加。
            //dp[j] += dp[j - coins[i]]

            int[] dp = new int[amount + 1];

            dp[0] = 1;

            //题目是问装满背包的方法（组合的种数），如果先遍历背包，会重复，实际是排列数而不是组合数
            for (int i = 0; i < coins.length; i++) {
                // 先遍历物品，物品挨个进背包
                // 从coins[i]开始，比如遍历了1、2 就不会出现2、1 相当于为组合去重了
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] += dp[j - coins[i]];
                }

                for (int e : dp) {
                    System.out.print(e + "\t");
                }
                System.out.println("\t");
            }

            System.out.println("===============================");
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 0;
            }
            dp[0] = 1;
            //先遍历背包，会重复，实际是排列数而不是组合数
            for (int j = 0; j <= amount; j++) {
                for (int i = 0; i < coins.length; i++) {
                    if (coins[i] <= j) {
                        dp[j] += dp[j - coins[i]];
                    }

                }


                for (int i : dp) {
                    System.out.print(i + "\t");
                }
                System.out.println("\t");

            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
