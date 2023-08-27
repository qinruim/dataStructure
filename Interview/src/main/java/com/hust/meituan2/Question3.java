package com.hust.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Package： com.hust.meituan2
 * @Title: Question3
 * @Author： qrpop
 * @Date： 2023-08-26 10:44
 * @description: 数组长度为n 最多操作k次
 *              每次操作：1.选择两个数（下标） i 、j
 *                      2.选两个整数 xy 使 x*y = ai*aj
 *                      3.ai，aj替换成x，y
 *              希望最终数组总和最大
 *
 *          输入：n、k
 *              a1，。。。。an
 *
 *           输出数组元素和 （对10^9+7 取模）
 *
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        final long abs = 1000000007;

        k = Math.min(k + 1,n);

        long sums = 1;
        int right = n - 1;
        for (int i = 0; i < k; i++) {
            sums = (sums * nums[right]);
            right--;
        }

        for (int i = 0; i < n - k; i++) {
            sums = (sums + nums[i]);
        }

        System.out.println((sums + k - 1) % abs);

    }
}
