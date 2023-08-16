package practice.realQuestions.xiaohongshu;

import java.util.Map;
import java.util.Scanner;

/**
 * 小红很喜欢前往小红书分享她的日常生活。
 * 已知她生活中有n个事件，分享第i个事件需要她花费ti的时间和hi的精力来编辑文章，并能获得ai的快乐值。
 * 小红想知道，在总花费时间不超过T且总花费精力不超过H的前提下，小红最多可以获得多少快乐值？
 *
 * 输入：第一行输入一个正整数n，代表事件的数量。
 *      第二行输入两个正整数T和H，代表时间限制和精力限制。
 *       接下来的n行，每行输入三个正整数ti,hi,ai，代表分享第i个事件需要花费ti的时间、hi的精力，收获ai的快乐值。
 *      1 ≤ n ≤ 50
 * 1 ≤ T,H ≤ 500
 * 1≤ ti,hi≤ 30
 * 1≤ ai ≤ 109
 *
 * 输出：一个整数，代表小红最多的快乐值。
 *
 *
 */
public class ShareLife {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int H = sc.nextInt();

//        int[][] tha = new int[n][2];
        int[] t = new int[n];
        int[] h = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
//            tha[i][0] = sc.nextInt();
//            tha[i][1] = sc.nextInt();
//            tha[i][2] = sc.nextInt();
            t[i] = sc.nextInt();
            h[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }

        getMostHappy(n,T,H,t,h,a);

    }

    private static void getMostHappy(int n, int T, int H, int[] t, int[] h, int[] a) {
        int[][][] dp = new int[n + 1][T + 1][H + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= T; j++) {
                for (int k = 0; k <= H; k++) {
                    dp[i][j][k] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= T; j++) {
                for (int k = 0; k <= H; k++) {
                    if (j >= t[i - 1] && k >= h[i - 1]){
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                                dp[i - 1][j - t[i - 1]][k - h[i - 1]] + a[i -1]);
                    }else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }

                }
            }

        }

        System.out.println(dp[n][T][H]);


    }


}
