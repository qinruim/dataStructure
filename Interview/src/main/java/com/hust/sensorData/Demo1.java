package com.hust.sensorData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package: com.hust.sensorData
 * @Title: Demo1
 * @Author: qinrui
 * @Date 2023-09-24 19:02
 * @description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        List<Integer> food = new ArrayList<>();
//        List<Integer> drink = new ArrayList<>();



        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int max = scanner.nextInt();
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
//        int[] foods = new int[ss1.length];
//        int[] drinks = new int[ss2.length];


        int res = 0;

        boolean[] used = new boolean[ss2.length];
        for (int i = 0; i < ss1.length; i++) {
//            foods[i] = Integer.parseInt(ss1[i]);
            int foodI = Integer.parseInt(ss1[i]);
            if (foodI <= max){
                res++;

                for (int j = 0; j < ss2.length; j++) {
                   int drinkI = Integer.parseInt(ss2[j]);
                    if (drinkI <= max){
                        if (!used[j]){
                            used[j] = true;
                            res++;
                        }

                        if (foodI + drinkI <= max){
                            res++;
                        }

                    }
                }
            }

        }


//        for (int j = 0; j < ss2.length; j++) {
//            drinks[j] = Integer.parseInt(ss2[j]);
//            if (drinks[j] <= max){
//                if (!used[j]){
//                    used[j] = true;
//                    res++;
//                }
//
//                if (foods[i] + drinks[j] <= max){
//                    res++;
//                }
//
//            }
//        }

        System.out.println(res);
    }
}
