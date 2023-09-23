package com.hust.mairui;

import java.util.Map;

/**
 * @Package： com.hust.mairui
 * @Title: Trans
 * @Author： qrpop
 * @Date： 2023-09-23 08:21
 * @description:
 */
public class Trans {
    public static void main(String[] args) {
//        intTOBin(); //10转2
//        eightToSix(); //8转16

        System.out.println(12 >> 2);

    }

    private static void eightToSix() {
        String octalNumber = "36"; // 八进制数

        int decimalNumber = octalToDecimal(octalNumber); // 步骤1：将八进制数转换为十进制数
        String hexadecimalNumber = decimalToHexadecimal(decimalNumber); // 步骤2：将十进制数转换为十六进制数

        System.out.println("八进制 " + octalNumber + " 转换成十六进制为: " + hexadecimalNumber);
    }

    private static String decimalToHexadecimal(int decimalNumber) {
        //10转16
        StringBuilder sb = new StringBuilder();
        while (decimalNumber > 0){
            int remain = decimalNumber % 16;
            char d = (char) (remain < 10 ? remain + '0' :  remain - 10 + 'A');
            sb.insert(0,d);
            decimalNumber /= 16;
        }
        return sb.toString();
    }

    private static int octalToDecimal(String octalNumber) {
        //八进制转10进制
        int res = 0;
        int n = octalNumber.length();
        for (int i = 0; i < n; i++) {
            int d = octalNumber.charAt(i) - '0';
            res += d * Math.pow(8,n - 1 - i);
        }

        return res;
    }

    private static void intTOBin() {
        int a = 11;
//        System.out.println(1 % 2);
        if (a == 0){
            System.out.println(0);
        }
        StringBuilder sb = new StringBuilder();
        while (a > 0){
            int remind = a % 2;
            sb.insert(0,remind);
            a = a / 2;
        }

        System.out.println(sb.toString());
    }
}
