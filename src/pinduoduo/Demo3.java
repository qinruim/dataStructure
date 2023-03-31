package pinduoduo;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int start = -1, end = -1;  // 最大子数组的起始下标和结束下标
        int maxSum = Integer.MIN_VALUE;  // 最大子数组的和

        int dp = A[0];  // 初始化dp数组
        int curStart = 0, curEnd = 0;  // 当前子数组的起始下标和结束下标
        for (int i = 1; i < n; i++) {
            if (dp + A[i] > A[i]) {
                dp = dp + A[i];
                curEnd = i;
            } else {
                dp = A[i];
                curStart = curEnd = i;
            }
            if (dp > maxSum || (dp == maxSum && curEnd - curStart > end - start)) {
                maxSum = dp;
                start = curStart;
                end = curEnd;
            }
        }

        if (maxSum < 0) {
            System.out.println("-1");  // 数组B为空数组
        } else {
            System.out.println(start + " " + end);
        }





    }

}