package practice.realQuestions.meituan;

import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: CycleRoad
 * @Author： qrpop
 * @Date： 2023-08-12 10:23
 * @description:   有一个环形公路，上面有n站，现给定顺时针第i站到第i+1站的距离（也给了第n站到第1站的距离）
 *                 小美想沿着公路从第x站走到第y站，求最短距离
 *
 *                 输入：第一行输入n，代表站数
 *                     第二行输入n个ai，代表第i站到第i+1站的距离（和第n站到第1站的距离）
 *                     第三行输入两个正整数x、y，代表起止站
 *                 输出：一个正整数，表示小美走的最短距离
 */
public class CycleRoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //站点数量
        int[] a = new int[n + 1];
        int totalDistance = 0;
        for (int i = 1; i <= n; i++) {
            //i到i+1的距离
            a[i] = scanner.nextInt();
            totalDistance += a[i];
        }
        //起止点
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        //顺、逆时针距离
        int positiveDistance = 0;
        int negativeDistance = 0;

        if (x == y){
            System.out.println(0);
        }
        if (x > y){
//            swap(x,y);
            for (int i = y; i < x; i++) {
                positiveDistance += a[i];
            }

            negativeDistance = totalDistance - positiveDistance;


//            if (positiveDistance - negativeDistance >= 0) {
//                System.out.println(negativeDistance);
//            }else {
//                System.out.println(positiveDistance);
//            }
        }
        if (x < y){
            for (int i = x; i < y; i++) {
                positiveDistance += a[i];
            }

            negativeDistance = totalDistance - positiveDistance;


//            if (positiveDistance - negativeDistance >= 0) {
//                System.out.println(negativeDistance);
//            }else {
//                System.out.println(positiveDistance);
//            }
        }


        if (positiveDistance - negativeDistance >= 0) {
            System.out.println(negativeDistance);
        }else {
            System.out.println(positiveDistance);
        }

    }

    private static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = x;
    }
}
