package meituanInterview;

public class MostDeliciousCandy {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,78,5,2};
        System.out.println(maxCandy(a));
    }

    public static int maxCandy(int[] a) {
        int n = a.length;
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return a[0];
        } else if (n == 2) {
            return Math.max(a[0], a[1]);
        } else if (n == 3) {
            return Math.max(a[0]+a[2], a[1]);
        }
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);
        dp[2] = Math.max(a[0]+a[2], a[1]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-3] + a[i]);
        }
        return dp[n-1];
    }

}
