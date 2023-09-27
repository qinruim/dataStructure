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
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int max = scanner.nextInt();
        String[] foods = s1.split(" ");
        String[] drinks = s2.split(" ");
        int res = 0;

        boolean[] used = new boolean[drinks.length];
        for (int i = 0; i < foods.length; i++) {
            int foodI = Integer.parseInt(foods[i]);
            if (foodI <= max){
                res++;
                for (int j = 0; j < drinks.length; j++) {
                   int drinkI = Integer.parseInt(drinks[j]);
                    if (drinkI <= max){
                        if (!used[j]){
                            used[j] = true;
                            res++;
                            if (foodI + drinkI <= max){
                                res++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
