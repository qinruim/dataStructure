package meituan;

import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: TreeColor
 * @Author： qrpop
 * @Date： 2023-08-12 11:49
 * @description: 给树染色
 */
public class TreeColor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tree = new int[n+1];
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
        }



    }
}
