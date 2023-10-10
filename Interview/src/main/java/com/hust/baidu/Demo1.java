package com.hust.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Package： com.hust.baidu
 * @Title: demo1
 * @Author： qrpop
 * @Date： 2023-10-10 19:27
 * @description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] min = new int[m + 1];
        Arrays.fill(min,Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int index = scanner.nextInt();
            int count = scanner.nextInt();
            min[index] = Math.min(count,min[index]);
        }

        int total = 0;
        for (int i = 1; i <= m; i++) {
            if (min[i] != Integer.MAX_VALUE){
                total += min[i];
            }
        }

        System.out.println(total > k ? k : total);
    }
}
