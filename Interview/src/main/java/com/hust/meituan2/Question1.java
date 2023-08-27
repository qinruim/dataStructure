package com.hust.meituan2;

import com.hust.Main;

import java.security.cert.X509Certificate;
import java.util.Scanner;

/**
 * @Package： com.hust.meituan2
 * @Title: Question1
 * @Author： qrpop
 * @Date： 2023-08-26 10:05
 * @description: 果树可以每天浇水 +x  隔两天施肥 +y  到z就可以了
 * 最少需要多少天
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        int a = z / (x*3 + y);
        int b = z % (x*3 + y);

        if (b == 0){
            System.out.println(a * 3);
        }else if (b > 0 && b <= x +y){
            System.out.println(a * 3 + 1);
        }else if (b > x + y && b <= 2 * x + y){
            System.out.println(a * 3 + 2);
        }else {
            System.out.println(a * 3 + 3);
        }


//        int[] dp = new int[z + 1];
//
//        if (x + y >= z){
//            System.out.println(1);
//        }
//
//        dp[1] = x + y;
//        int res = 0;
//
//        for (int i = 2; i <= z; i++) {
//            if ( (i - 1) % 3 == 0){
//                dp[i] = dp[i - 1] + x + y;
//            }else {
//                dp[i] = dp[i - 1] + x;
//            }
//            if (dp[i] >= z){
//                res = i;
//                break;
//            }
//        }
//
////        for (int i : dp) {
////            System.out.println(i);
////        }
//
//        System.out.println(res);

    }
}
