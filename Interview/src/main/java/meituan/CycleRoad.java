package meituan;

import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: CycleRoad
 * @Author： qrpop
 * @Date： 2023-08-12 10:23
 * @description: 环形公路，两点最短距离
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
