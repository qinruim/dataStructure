package com.hust.sensorData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * @Package: com.hust.sensorData
 * @Title: Demo2
 * @Author: qinrui
 * @Date 2023-09-24 19:32
 * @description:
 */
public class Demo2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //天数
        int m = scanner.nextInt(); //任务数
        int[] resources = new int[m];
        for (int i = 0; i < m; i++) {
            resources[i] = scanner.nextInt();
        }
        int res = 0;
        if (m < n) {
            System.out.println(-1);
            return;
        }
        if (m == n) {
            for (int i = 0; i < resources.length; i++) {
                res += resources[i];
            }
            System.out.println(res);
            return;
        }

        res = minResources(m, resources, n);
        System.out.println(res);
    }


    public static int minResources(int m, int[] resources, int n) {
        //dp[i][j]:j天 完成i个任务所需的最小资源
        int[][] dp = new int[m + 1][n + 1];
        int sum = 0;

        for (int i = 1; i <= m; i++) {
            sum = Math.max(sum,resources[i - 1]);
            dp[i][1] = sum;
        }

        for (int i = 2; i <= m; i++) {//i个任务
            for (int j = 2; j <= n && j <= i; j++) {//j天
                int rsi = resources[i - 1]; //第i个资源
                dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j - 1] + rsi);
            }
        }

        return dp[m][n];
    }


}
