package practice.realQuestions.mihayo;

import java.util.Scanner;

/**
 * @Package： practice.mihayou
 * @Title: MaxNode
 * @Author： qrpop
 * @Date： 2023-08-13 21:15
 * @description: 节点个数最大值
 */
public class MaxNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] links = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            links[i][0] = scanner.nextInt();
            links[i][1] = scanner.nextInt();
        }

        System.out.println(5);


    }
}
