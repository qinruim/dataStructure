package com.hust.hwnewcoder;

import java.util.Scanner;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ16购物单
 * @Author： qrpop
 * @Date： 2023-09-11 13:56
 * @description: 动规
 */
public class HJ16购物单 {
    /**
     * 1、如果只包含主件，则是经典的01背包问题
     * 2、现在加了附件，则最大值有四种情况：主件、主件+附件1、主件+附件2、主件+附件1+附件2
     第一步：记录原始数据
     记录每个主件以及其附件的关系，并记录其 价格 * 重要度
     第二步：遍历主件
     记录主件在四种情况下的最大值
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int money = in.nextInt() / 10; //总钱数
            int m = in.nextInt(); //物体件数

            //构建主、附件关系
            int[][] prices = new int[m + 1][3];  //三列记录 主+2副价格
            int[][] satis = new int[m + 1][3]; //记录满意度

            for (int i = 1; i <= m; i++) {
                int v = in.nextInt() / 10; //价格
                int p = in.nextInt(); //重要度
                int q = in.nextInt(); //主副
                int im = v * p; //满意度

                if (q == 0) { //主
                    prices[i][0] = v;
                    satis[i][0] = im;
                } else if (prices[q][1] == 0) {//主件的第一个附件
                    prices[q][1] = v;
                    satis[q][1] = im;
                } else if (prices[q][2] == 0) {//主件的第二个附件
                    prices[q][2] = v;
                    satis[q][2] = im;
                }
            }


            //dp[i][j] : 第i个物品 j块钱（包容量） 的最大满意度
            int[][] dp = new int[m + 1][money + 1];

            for (int i = 1; i <= m; i++) {
//                if(prices[i][0] == 0) continue;
                for (int j = 1; j <= money; j++) {
                    dp[i][j] = dp[i - 1][j];

                    //分四种情况讨论：只买主件i，只买主件+附件1，只买主件+附件2，买主件+2个附件
                    //找这四种情况中的最大值
                    int primaryPrice = prices[i][0];
                    if (primaryPrice == 0)continue;
                    int attachPrice1 = prices[i][1];
                    int attachPrice2 = prices[i][2];
                    int primaryStatis = satis[i][0];
                    int attachStatis1 = satis[i][1];
                    int attachStatis2 = satis[i][2];

                    //主件
                    dp[i][j] = j - primaryPrice >= 0 ?
                            Math.max(dp[i][j],
                                    dp[i - 1][j - primaryPrice] + primaryStatis)
                            : dp[i][j];
                    //主件+附件1
                    dp[i][j] = j - primaryPrice - attachPrice1 >= 0 ?
                            Math.max(dp[i][j],
                                    dp[i - 1][j - primaryPrice - attachPrice1] + primaryStatis + attachStatis1)
                            : dp[i][j];
                    //主件+附件2
                    dp[i][j] = j - primaryPrice - attachPrice2 >= 0 ?
                            Math.max(dp[i][j],
                                    dp[i - 1][j - primaryPrice -attachPrice2 ] + primaryStatis + attachStatis2)
                            : dp[i][j];
                    //主件+两个附件
                    dp[i][j] = j - primaryPrice - attachPrice1 - attachPrice2 >= 0 ?
                            Math.max(dp[i][j],
                                    dp[i - 1][j - primaryPrice - attachPrice1 - attachPrice2 ] + primaryStatis + attachStatis1 + attachStatis2)
                            : dp[i][j];


                }
            }


            System.out.println(dp[m][money] * 10);

//        }
    }
}
