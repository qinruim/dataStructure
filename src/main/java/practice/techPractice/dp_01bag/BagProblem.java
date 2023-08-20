package practice.techPractice.dp_01bag;

/**
 * @Package： dp_01bag
 * @Title: TwoDimension
 * @Author： qrpop
 * @Date： 2023-08-12 16:10
 * @description: 二维dp数组，01背包问题
 */
public class BagProblem {
    public static void main(String[] args) {
        //三个物品的重量
        int[] weight = {1,3,4};
        //三个物品的价值
        int[] value = {15,20,30};
        //背包容量
        int bagSize = 4;

        //动态规划获得背包能装的最大价值（二维dp数组）
        getMaxValueWithTwoDivDP(weight,value,bagSize);

        //动态规划获得背包能装的最大价值（一维dp数组）
        getMaxValueWithOneDivDP(weight,value,bagSize);
    }



    /**
     * 二维dp数组
     * @param weight
     * @param value
     * @param bagSize
     */
    private static void getMaxValueWithTwoDivDP(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize + 1];

        //初始化dp数组
        //第一行，可以装下物品0的包初始化为物品0的value    其余都初始化为0(创建数组后默认值即为0，不动)
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        //遍历 递推公式：dp[i][j] = max(dp[i-1][j],dp[i-1][j - weight[i]] + value[i])
        //先遍历物品 再遍历背包(从1，1开始遍历，因为第一行第一列都已确定)
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]){
                    //当前背包的容量都没有当前物品i大的时候，是不放物品i的。
                    // 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                    dp[i][j] = dp[i - 1][j];
                }else {
                    //当前背包的容量可以放下物品i
                    //那么此时分两种情况：
                    //   1、不放物品i
                    //   2、放物品i
                    //比较这两种情况下，哪种背包中物品的最大价值最大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }


        System.out.println(dp[weight.length-1][bagSize]);

        //打印dp数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("\t");
        }
    }


    /**
     * 一维dp数组
     * @param weight
     * @param value
     * @param bagSize
     */
    private static void getMaxValueWithOneDivDP(int[] weight, int[] value, int bagSize) {
        //全部初始化为0
        int[] dp = new int[bagSize + 1];

        /**
         * 必须先遍历物品的原因（两种理解）：
         * 1.如果是二维dp数组，那么先遍历背包，后遍历物品，实际上是一列一列的计算出每个位置的最大价值，
         *   而对于一维数组来说， 只有一行数据， 当前行的数据是受上一行数据的影响 ，所以先遍历背包，后遍历物品本质上来说就是一个悖论
         *
         * 2.因为一维dp的写法，背包容量一定是要倒序遍历（原因上面已经讲了），如果遍历背包容量放在上一层，
         * 那么每个dp[j]就只会放入一个物品，即：背包里只放入了一个物品。
         * 例如求dp[4]时，j=4,i=0,需要由max(dp[4], dp[4 - weight[0]] + value[0]),
         * 即max(dp[4],dp[3] +value[0])由于先遍历的背包容量，
         * 因此此时的dp[3]，dp[4]还没有求，仍然为初始值0，此时最大值必然为value[0]，
         * 即每个dp[j]相当于只放了一个物品，因此不能先遍历背包容量
         */


        //遍历 先遍历物品 后遍历背包 且要倒序
        //递推公式： dp[j] = max(dp[j],dp[j - weight[i]] + value[i])
        for (int i = 0; i < weight.length; i++) { //遍历物品
            for (int j = bagSize; j >= weight[i]; j--) { //遍历背包容量
                dp[j] = Math.max(dp[j],dp[j -weight[i]] + value[i]);
            }
        }

        System.out.println(dp[bagSize]);

        //打印dp数组
        for (int j : dp) {
            System.out.print(j+" ");
        }
    }


}
