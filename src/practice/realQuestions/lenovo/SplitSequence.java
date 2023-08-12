package practice.realQuestions.lenovo;

import java.util.*;

/**
 * 定义f(A)表示将序列 A 进行 unique 操作之后的序列的元素个数。
 * unique 操作是指将相邻且相同的元素合成一个元素，再按照原序列的相对顺序进行排列之后得到的序列。
 * 例如，[1,1,1,2,2,3,3,1] 进行 unique 操作之后的序列为 [1,2,3,1]；
 * [1,2,3,3,2,1] 进行 unique 操作之后的序列为 [1,2,3,2,1]；
 * [1,1,1,1,1] 进行 unique 操作之后得到的序列为 [1]。
 *
 * 现在，输入一个长度为n的序列S，你需要将其划分为k段，使得每一段都不为空，且你需要最大化所有段的f函数的值之和。你只需要输出这个最大值就行。
 *
 *
 * 输入描述
 * 第一行两个正整数n,k(1≤k≤n≤105)；
 * 第二行n个由空格隔开的正整数a1,a2,...,an(1 ≤ ai ≤10000)，表示输入的序列S。
 *
 * 输出描述
 * 输出一个整数，表示所求的最大值。
 *
 * 样例输入
 * 8 3
 * 1 1 1 2 2 3 3 1
 * 样例输出
 * 6
 */
public class SplitSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = scanner.nextInt();
        }

        int result = backTracking(seq, k, 0, n - 1);
//        int result = dynamicProgramming(seq, k);
        System.out.println(result);


    }

    private static int dynamicProgramming(int[] seq, int k) {
        int n = seq.length;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int count = 0;
                dp[i][j] = dp[i - 1][j];  // 默认情况，当前元素单独成为一段
                for (int x = i; x >= 1; x--) {
                    if (seq[x - 1] == seq[i - 1]) {
                        count++;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[x - 1][j - 1] + count * count);
                }
            }
        }

        return dp[n][k];
    }


    public static int backTracking(int[] seq, int k, int start, int end){
        if (k == 1){
            return getLength(seq, start, end);
        }
        int result = 0;
        for (int i = start; i < end; i++) {
            int tempResult = getLength(seq, start, i) + backTracking(seq, k - 1, i + 1, end);
            result = Math.max(result, tempResult);
        }
        return result;
    }

    public static int getLength(int[] seq, int start, int end){
        int length = 1;
        for (int i = start; i < end; i++) {
            if (seq[i] != seq[i + 1]){
                length++;
            }
        }
        return length;
    }
}
