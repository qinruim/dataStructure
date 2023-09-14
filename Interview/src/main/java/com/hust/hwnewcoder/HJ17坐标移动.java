package com.hust.hwnewcoder;

import java.util.Scanner;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ17坐标移动
 * @Author： qrpop
 * @Date： 2023-09-12 10:15
 * @description:
 */
public class HJ17坐标移动 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();

        String[] ss = s.split(";");
        int n = ss.length;
        if(n == 0){
            System.out.println("0,0");
        }
        int[] res = new int[2];

        for(int i = 0;i < n;i++){

//            if(unValid(ss[i])){continue;}
            if(!ss[i].matches("[AWSD][0-9]{1,2}")){continue;}
            String direc = ss[i].substring(0,1);
            int step = Integer.parseInt(ss[i].substring(1,ss[i].length()));
            if(direc.equals("A")){
                res[0] -= step;
            }else if(direc.equals("S")){
                res[1] -= step;
            }else if(direc.equals("W")){
                res[1] += step;
            }else if(direc.equals("D")){
                res[0] += step;
            }
        }

        System.out.println(res[0] + "," + res[1]);
    }

    /**判断小字符串是否有效  无效返回true */
    private static boolean unValid(String S){
        int n = S.length();
        if (n == 0){
            return true;
        }
        char dire = S.charAt(0);
        if(dire != 'A' && dire != 'D' && dire != 'W' && dire != 'S'){
            return true;
        }
        if(n == 1 || n > 3){
            return true;
        }
        for(int i = 1;i < n;i++){
            char ch = S.charAt(i);
            if(ch < '0' || ch > '9'){
                return true;
            }
        }

        return false;


    }
}
