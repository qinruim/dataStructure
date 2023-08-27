package com.hust.meituan2;

import java.util.Scanner;

/**
 * @Package： com.hust.meituan2
 * @Title: Question5
 * @Author： qrpop
 * @Date： 2023-08-26 11:14
 * @description:    长度为n的数组，求平均数正好等于k的最长连续子数组长度
 */
public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }

//        int left = 0,right = 0;
//        while (right <= n){
//
//
//
//        }


//        int res = -1;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum == k *(j - i + 1)){
//                    res = Math.max(res,j - i + 1);
//                }
//
//            }
//        }
//        System.out.println(res);


//        int left = 0;
//        int right = n - 1;
//
//        while (left <= right){
//            if (sum == k * (right -left + 1)){
//                System.out.println(right - left + 1);
//                break;
//            }else if (sum > k * (right - left + 1)){
//                if (nums[left] > nums[right]){
//                    sum -= nums[left];
//                    left++;
//                }else {
//                    sum -= nums[right];
//                    right--;
//                }
//            }else {
//                if (nums[left] < nums[right]){
//                    sum -= nums[left];
//                    left++;
//                }else {
//                    sum -= nums[right];
//                    right--;
//                }
//
//            }
//
//
//        }
//
//        if (left > right){
//            System.out.println(-1);
//        }



        //前i位的和
//        int[] preSum = new int[n + 1];
//        int res = -1;
//
//        for (int i = 1; i <= n; i++) {
//            preSum[i] = preSum[i - 1] + nums[i -1];
//        }
//
//        // 当前位置结尾的子数组的最大长度
//        int[] dp = new int[n + 1];
//        for (int end = 1; end <= n ; end++) {
//            for (int begin = 0; begin < end; begin++) {
//                int sum = preSum[end] - preSum[begin];
//                if (sum == k * (end - begin)){
//                    dp[end] = Math.max(dp[end],dp[begin] + end - begin);
//                    res = Math.max(res,dp[end]);
//                }
//
//            }
//            dp[end] = Math.max(dp[end],dp[end - 1]);
//
//
//
//        }
//
//
//        System.out.println(res);

    }
}
