package meituan;

import java.util.Scanner;
import java.util.function.DoublePredicate;

/**
 * @Package： meituan
 * @Title: CutCake
 * @Author： qrpop
 * @Date： 2023-08-12 11:27
 * @description: cake2
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
