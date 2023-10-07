package com.hust.huawei;

import java.util.Map;
import java.util.Scanner;

/**
 * @Package： com.hust.huawei
 * @Title: Poly
 * @Author： qrpop
 * @Date： 2023-09-27 19:08
 * @description: 多项式计算
 */
public class Poly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String x = scanner.nextLine();

        String[] polyA = a.split(" ");
        String[] polyB = b.split(" ");
        int na = polyA.length;
        int nb = polyB.length;
        int len = Math.min(na,nb);
        int max = Math.max(na,nb);

        int[] res = new int[max];
        if (x.equals("+") || x.equals("-")){
            boolean flag = x.equals("+") ? true : false;
            for (int i = 0; i < len; i++) {
                int ai = Integer.parseInt(polyA[na - i - 1]);
                int bi = Integer.parseInt(polyB[nb - i - 1]);
                if (flag){
                    res[max - 1 - i] = ai + bi;
                }else {
                    res[max - 1 - i] = ai - bi;
                }
            }
            String[] rest = na > nb ? polyA : polyB;
            for (int i = 0; i < max - len; i++) {
                res[i] = Integer.parseInt(rest[i]);
            }
        }

//        if (x.equals("*")){
//
//        }



        int i = 0;
        while (res[i] == 0){
            i++;
        }
        for (int j = i; j < res.length; j++) {
            System.out.print(res[j] + " ");

        }


    }
}
