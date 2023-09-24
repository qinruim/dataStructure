package com.hust.sensorData;

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
    static int res = Integer.MAX_VALUE;
    static LinkedList<Integer> path = new LinkedList<>();
    static int[] resources;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        if (n > m){
            System.out.println(-1);
            return;
        }

        resources = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            resources[i] = scanner.nextInt();
            sum += resources[i];
        }

        if (n == m){
            System.out.println(sum);
            return;
        }

        backtrack(0,n);
        System.out.println();
        Random random = new Random();
        int i = random.nextInt(sum);
    }

    private static void backtrack(int startIndex, int k) {
        if (path.size() == k){
            if (check(path)){
                int sum = 0;
            }
        }
    }

}
