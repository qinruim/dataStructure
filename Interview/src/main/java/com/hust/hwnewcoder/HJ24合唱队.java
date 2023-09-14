package com.hust.hwnewcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ24合唱队
 * @Author： qrpop
 * @Date： 2023-09-14 16:59
 * @description: 找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 */
public class HJ24合唱队 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] hs = new int[n];
        for (int i = 0; i < n; i++) {
            hs[i] = scanner.nextInt();
        }
        int res = Integer.MAX_VALUE;


        for (int i = 1; i < n - 1; i++) {
            int countR = 0;
            //朝两边遍历 每一边两个指针
            //1.右边
            int l = i,r = i + 1;
            while (r <= n - 1){
                if (hs[r] >= hs[l]){
                    r++;
                    countR++;
                }else {
                    l = r;
                    r++;
                }
            }
            if (countR == n - 1 - i){
                continue;
            }

            int countL = 0;
            l = i - 1;
            r = i;
            //2.左边
            while (l >= 0){
                if (hs[l] >= hs[r]){
                    l--;
                    countL++;
                }else {
                    r = l;
                    l--;
                }
            }
            if (countL == i){
                continue;
            }

        res = Math.min(res, countL + countR);
        }

        System.out.println(res);

    }


}

