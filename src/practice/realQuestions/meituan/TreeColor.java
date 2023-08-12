package practice.realQuestions.meituan;

import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: TreeColor
 * @Author： qrpop
 * @Date： 2023-08-12 11:49
 * @description:  有一棵树，每个节点有一个权值，初始每个节点都是白色
 *                小美每次选择相邻两个节点，如果都是白色且权值的乘积是完全平方数，就可以将两个节点染红
 *                小美最多能染红多少个节点？
 *
 *                输入：第一行输入一个正整数n，代表节点个数
 *                      第二行输入n个正整数ai，代表每个节点的权值
 *                      接下里啊n-1行，每行输入两个正整数u、v，代表节点u、v之间有一条边连接
 *
 *                输出：最多能染红的节点个数
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
