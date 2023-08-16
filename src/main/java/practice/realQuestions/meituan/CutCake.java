package practice.realQuestions.meituan;

import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: CutCake
 * @Author： qrpop
 * @Date： 2023-08-12 11:27
 * @description: 小美有一个矩形蛋糕，分成n行m列共n*m个区域，每个区域是个小正方形，有一个美味值
 *               她将蛋糕切一刀，分为两个部分（不能把小正方形且开成两个区域），跟小团一人吃一部分
 *               要求两个人吃到的美味度s1和s2之和尽量接近，输出|s1-s2|的最小值
 *
 *               输入：第一行输入两个正整数n，m
 *                    接下来n行，每行输入m个ai，表示美味值
 *               输出:最小的|s1-s2|
 */
public class CutCake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n行m列
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] cake = new int[n][m];
        int[][] sum = new int[n][m];
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cake[i][j] = scanner.nextInt();
                total += cake[i][j];

                if (i == 0 && j == 0){
                    sum[i][j] = cake[i][j];
                }
                else if (i == 0 && j != 0){
                    sum[i][j] = sum[i][j - 1] + cake[i][j];
                }else if (i != 0 && j == 0){
                    sum[i][j] = sum[i - 1][j] + cake[i][j];
                }else {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + cake[i][j] - sum[i - 1][j - 1];
                }
            }
        }

        int[] ySum = sum[n - 1];

        int s1 = 0;
        int s2 = 0;
        int result = Integer.MAX_VALUE;

        //横向切割
        for (int y : ySum) {
            result = Math.min(result,Math.abs(2 * y - total));
        }

        //纵向切割
        int[] xSum = new int[n];
        for (int i = 0; i < n; i++) {
            xSum[i] = sum[i][m - 1];
        }
        for (int x : xSum) {
            result = Math.min(result,Math.abs(2 * x - total));
        }

        System.out.println(result);

    }
}
