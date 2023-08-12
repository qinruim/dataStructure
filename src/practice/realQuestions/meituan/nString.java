package practice.realQuestions.meituan;

import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: nString
 * @Author： qrpop
 * @Date： 2023-08-12 11:39
 * @description:    小美有一个长度为n的，将其从左到右平铺成一个矩阵（先平铺第一行，再第二行，类推）
 *                  矩阵有x行y列（x*y=n）；矩阵的权值定义为连通块（上下左右任意方向有相同的字符，即是连通的）的数量，
 *                  求矩阵最小的权值
 *
 *                  输入：第一行输入一个正整数n，表示字符串长度
 *                      第二行输入一个长度为n的，仅由小写字母组成的字符串
 *
 *                  输出：最小的权值
 *
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
