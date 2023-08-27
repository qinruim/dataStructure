package com.hust.meituan2;

import java.util.Scanner;

/**
 * @Package： com.hust.meituan2
 * @Title: Question2
 * @Author： qrpop
 * @Date： 2023-08-26 10:31
 * @description:    n、m表示账单数和除小红外总人数
 *                  2*n行 每2行一个账单
 */
public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //账单数
        int m = scanner.nextInt();  //人数

        int[] res = new int[m];

        for (int i = 0; i < n; i++) {
            int people = scanner.nextInt();
            int cash = scanner.nextInt();

            int cashForPerson = (cash % people) == 0 ? cash/people : cash/people + 1;

            for (int j = 0; j < people - 1; j++) {
                res[scanner.nextInt() - 1] += cashForPerson;
            }
        }

        for (int e : res) {
            System.out.print(e+"\t");
        }


    }
}
