package meituanInterview;

import java.util.Scanner;

public class CandyEveryDay {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] a = new int[n];
        for (int i = 0; i < n; i++) {
        a[i] = scanner.nextInt();
    }

    int[] dp = new int[n];
    dp[0] = a[0];
        for (int i = 1; i < n; i++) {
        dp[i] = dp[i - 1];
        if (i == 1 || i == 2) { // 处理第一天和第二天的情况
            dp[i] += a[i];
        } else {
            dp[i] = Math.max(dp[i], dp[i - 2] + a[i]); // 不连续吃糖
            if (k > 0) { // 连续吃糖
                dp[i] = Math.max(dp[i], dp[i - 3] + a[i]);
                k--;
            }
        }
    }
        System.out.println(dp[n - 1]);
}

