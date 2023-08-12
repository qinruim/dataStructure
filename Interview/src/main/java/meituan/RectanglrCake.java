package meituan;

import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: RectanglrCake
 * @Author： qrpop
 * @Date： 2023-08-12 10:48
 * @description: 切割矩形区域，每个小区域有个权值，使两部分的权值和最接近
 */
public class RectanglrCake {
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
//                    sum[i][j] =
                }
            }
        }

        int s1 = 0;
        int s2 = 0;
        int result = Integer.MAX_VALUE;
        //横向切割
        for (int i = 0; i < n - 1; i++) {
//            int[] s1i = cake[i];
//            sumOfArray(s1i);

            for (int j = 0; j <= i; j++) {
                s1 += sumOfArray(cake[j]);
            }
            s2 = total - s1;

            result = Math.min(result,Math.abs(s1 - s2));


        }

        //纵向切割
        s1 = 0;
        s2 = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j <= i; j++) {
                s1 += columnSum(i,n,cake);
            }
            s2 = total - s1;

            result = Math.min(result,Math.abs(s1 - s2));
        }

        System.out.println(result);



    }

    private static int columnSum(int i, int n, int[][] cake) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += cake[j][i];
        }

        return sum;

    }

    private static int sumOfArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
