package meituan;

import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: nString
 * @Author： qrpop
 * @Date： 2023-08-12 11:39
 * @description: 字符串平铺成矩阵，求权值
 */
public class nString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.nextLine();

        if (n == 1){
            System.out.println(0);
            return;
        }
        if (n == 2){
            if (s.charAt(0) == s.charAt(1)){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
            return;
        }
        if (n == 3){
            if (s.charAt(1) != s.charAt(0) && s.charAt(1) != s.charAt(2)){
                System.out.println(0);
            }else if (s.charAt(1) == s.charAt(0) && s.charAt(1) != s.charAt(2)){
                System.out.println(1);
            }else if (s.charAt(1) != s.charAt(0) && s.charAt(1) == s.charAt(2)){
                System.out.println(1);
            }else if (s.charAt(1) == s.charAt(0) && s.charAt(1) == s.charAt(2)){
                System.out.println(1);
            }
            return;
        }
    }
}
