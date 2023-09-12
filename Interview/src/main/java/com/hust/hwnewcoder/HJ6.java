package com.hust.hwnewcoder;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.util.*;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ6
 * @Author： qrpop
 * @Date： 2023-09-12 10:25
 * @description:
 *               输入一个正整数，按照从小到大的顺序输出它的所有质因子
 *               （重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class HJ6 {
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

//        int k = (int) Math.sqrt(num);
//
//        for (int i = 2; i <= k ; i++) {
//            while (num % i ==0){
//                System.out.println(i + " ");
//                num /= i;
//            }
//        }
//        System.out.println(num == 1 ? "" : num +" ");




//        //递归 分解当前的数 分解它分接出来的数 知道无法分解
        split(num);

       Integer[] array = res.stream().toArray(Integer[] ::new);

       Arrays.sort(array);

        for (int i : array) {
            System.out.println(i + " ");

        }

        for (Integer re : res) {
            System.out.println(re + " ");
        }



    }
    static boolean flag = false;

    private static void split(int num) {
//        if (!flag){
//            return;
//        }
        if (num == 1){
            return;
        }
        if (num == 2 || num == 3){
//            System.out.println(2 + " ");
            res.add(num);
            return;
        }


//        boolean flag = false;
        //用2开始到num/2 的数挨个去除num
        for (int i = 2; i <= Math.sqrt(num) ; i++) {
            //能除尽 可以分解
            if (num % i == 0){
                split(i);
                split(num / i);
                flag = true;
            }
        }
        //若num无法分解
        if (!flag){
            res.add(num);
        }
    }
}
