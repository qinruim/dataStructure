package practice.techPractice.dp_fullBag;

/**
 * @Package： practice.techPractice.dp_fullBag
 * @Title: PureFullbag
 * @Author： qrpop
 * @Date： 2023-08-20 16:46
 * @description: 纯完全背包问题
 */
public class PureFullBag {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;

        int[] dp = new int[bagWeight + 1];

        //先遍历物品 再遍历背包
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j],dp[j - weight[i]] + value[i]);
            }

            for (int e : dp) {
                System.out.print(e + "\t");
            }
            System.out.println("\t");

        }


        System.out.println("============================");

        //先遍历背包 再遍历物品
        for (int j = 0; j <= bagWeight; j++) {
            for (int i = 0; i < weight.length; i++) {
                if (j >= weight[i]){
                    dp[j] = Math.max(dp[j],dp[j - weight[i]] + value[i]);
                }
            }

            for (int e : dp) {
                System.out.print(e + "\t");
            }
            System.out.println("\t");

        }


    }
}
