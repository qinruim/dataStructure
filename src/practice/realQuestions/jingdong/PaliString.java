package practice.realQuestions.jingdong;

import java.util.Scanner;

/**
 * @Package： practice.realQuestions.jingdong
 * @Title: PaliString
 * @Author： qrpop
 * @Date： 2023-08-12 20:20
 * @description: 小红有个长度为只包含小写字的字符串她想把这个字符串通过以下操作交成回文串：
 *              1,选择字符串的第一个字母，将其插在字符串的末尾。例如，对于字符电abc,得到ca,
 *              2.选择一个字符串的一个字符，将这个字符变成任意小写字母。
 *               每次只能进行上述两种操作的一种，小红想知道最少需要进行多少次操作才能将字符串变成向文串。
 *              输入描述：第一行—个正数n，代表字符串的长度。
 *                      第二行一—个长度为n的仅包含小写字母的字符串，代表小红的字符串。

 *              输出描述：一行一个正数，代表最小的操作数精使用交成回文串：
 */

public class PaliString {
    public static int minOperationsToPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();  // Read the newline after the integer input
        String str = scanner.nextLine();
        scanner.close();

        int result = minOperationsToPalindrome(str);
        System.out.println(result);
    }
}
