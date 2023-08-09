package com.hust;


import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
//        System.out.println("hello world!");
//        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
//        objectObjectConcurrentHashMap.put("1","2");

        String input = "-34.87";
        double result = customParseDouble(input);
        System.out.println(result);
    }

    private static double customParseDouble(String input) {

        double result = 0.0;
        //考虑负数
        boolean flag = false;
        if (input.charAt(0) == '-'){
            flag = true;
            input = input.substring(1);
        }


        String[] split = input.split("\\.");

//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }



        //整数部分
        for (int i = 0; i < split[0].length(); i++) {
            double temp = split[0].charAt(i) - '0';
            result = result * 10 + temp;
        }

        //小数部分
        double decimal = 0.0;
        for (int i = split[1].length() - 1; i >= 0; i--) {
            double temp = split[1].charAt(i) - '0';
            decimal = decimal / 10 + temp;
        }
        decimal /= 10;


        result += decimal;

        if (flag){
            result = -result;
        }


        return result;

    }


}
