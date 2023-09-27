package com.hust.shein;

import java.util.Scanner;

/**
 * @Package： com.hust.shein
 * @Title: Demo2
 * @Author： qrpop
 * @Date：
 * @description:
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ss = scanner.nextLine();
        String[] in = ss.split(",");
        String s = in[0];
        int row = Integer.parseInt(in[1]);

        int n = s.length();
        int m = 2 * row -2;
        StringBuilder stringBuilder = new StringBuilder();
        if (n == 1){
            System.out.println(s);
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                int re = j % m;
                if (re == m - i || re == i){
                    stringBuilder.append(s.charAt(j));
                }
            }
        }

        String res = stringBuilder.toString();
        System.out.println(res);



    }

}
