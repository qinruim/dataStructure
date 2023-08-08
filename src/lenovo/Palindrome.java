package lenovo;

import java.util.Scanner;

/**
 * 我们称一个字符串为回文串，当且仅当这个串从左往右和从右往左读是一样的。例如，aabbaa、a、abcba 是回文串，而 ab、ba、abc 不是回文串。注意单个字符也算是回文串。
 * 现在，给你一个长度为n的字符串 S，接下来需要将这个串重新排列，组成一个新的字符串 T。首先，T 一开始为空，之后进行如下操作：
 * 从左往右开始，剪切 S 中开头k个字符构成的子串。如果该子串是一个回文串，就将其拼接在 T 的前面；否则，将其拼接在 T 的末尾。其中k是一个给定的参数。
 * 你需要输出最后 T 是多少。
 *
 * 输入描述
 * 第一行两个正整数 n,k(1≤n，k≤105)，其中k是n的因子。
 * 第二行输入字符串 S。该字符串仅由小写英文字母组成。
 *
 * 输出描述
 * 输出一行一个字符串，表示 T。
 *
 * 样例输入
 * 12 3
 * ababaacbaccc
 * 样例输出
 * cccababaacba
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String S = scanner.nextLine();
        String T = "";

        for (int i = 0; i <= n - k; i+=k) {
            String substring = S.substring(i, i + k);
            //回文 拼接到首部
            if (isPalindrome(substring)){
                T = substring + T;
            }else {
                //拼接到尾部
                T = T + substring;
            }
        }

        System.out.println(T);

    }

    private static boolean isPalindrome(String substring) {
        int first = 0;
        int last = substring.length() - 1;

        while (first < last){
            if (substring.charAt(first) != substring.charAt(last)){
                return false;
            }
            first++;
            last--;
        }

        return true;
    }
}
