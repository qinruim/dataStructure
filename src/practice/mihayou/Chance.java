package practice.mihayou;

import java.util.Scanner;

/**
 * @Package： practice.mihayou
 * @Title: Chance
 * @Author： qrpop
 * @Date： 2023-08-13 21:18
 * @description: 抽五星卡的概率
 */
public class Chance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double p = scanner.nextDouble();

        double[] dp = new double[91];

        dp[1] = p / 2;

        for (int i = 2; i < 90; i++) {
//            dp[i] = (1 - dp[i - 1]) * p / 2;
            dp[i] = Math.pow(1 - p/2,i-1) * p / 2;

        }
        dp[90] = Math.pow(1 - p/2,89) * 0.5;

        double result = 0.0;

        for (int i = 1; i < 90; i++) {
            result += dp[i] * i;

        }

        System.out.println(result);
    }

}
