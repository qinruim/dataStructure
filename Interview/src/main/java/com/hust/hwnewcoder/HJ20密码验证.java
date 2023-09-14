package com.hust.hwnewcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ20密码验证
 * @Author： qrpop
 * @Date： 2023-09-13 17:20
 * @description: 密码要求:  1.长度超过8位
 *                          2.包括大小写字母.数字.其它符号,以上四种至少三种
 *                          3.不能有长度大于2的包含公共元素的子串重复
 *                          （注：其他符号不含空格或换行）
 */
public class HJ20密码验证 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String psw = scanner.nextLine();

            boolean flag = isValidPSW(psw);

            if (flag){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }

    private static boolean isValidPSW(String psw) {
        char[] psws = psw.toCharArray();
        int n = psw.length();

        if (psws.length <= 8){
            return false;
        }

        //统计符号种类
        int small = 0,big = 0,num = 0,other = 0;

        for (int i = 0; i < n; i++) {
            char ch = psws[i];

            if (ch >= 'a' && ch <= 'z'){
                small = 1;
            }else if (ch >= 'A' && ch <= 'Z'){
                big = 1;
            }else if (ch >= '0' && ch <= '9'){
                num = 1;
            }else {
                other = 1;
            }
        }
        if (small + big + num + other < 3){
            return false;
        }

        //不能有长度大于2的包含公共元素的子串重复
        //用所有长度为三的字串对比即可 0~n-3  共n-2个
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            String sub = psw.substring(i,i+3);
            set.add(sub);
        }
        if (set.size() < n - 2){//有重复
            return false;
        }




        return true;
    }
}
