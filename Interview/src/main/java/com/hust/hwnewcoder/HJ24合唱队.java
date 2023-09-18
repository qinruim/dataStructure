package com.hust.hwnewcoder;

import java.util.*;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ24合唱队
 * @Author： qrpop
 * @Date： 2023-09-14 16:59
 * @description: 找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 */
public class HJ24合唱队 {

    public static void main(String[] args) {
//        method1();

        //最长递增子序列
        method2();
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] hs = new int[n];
        for (int i = 0; i < n; i++) {
            hs[i] = scanner.nextInt();
        }
        //分别获取正序、倒序的最长递增子序列数组
        int[] sub1 = getMaxSub(hs,true);//正序
        int[] sub2 = getMaxSub(hs,false);//倒序

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int left = i + 1 - sub1[i];
            int right = n - i - sub2[i];
            res = Math.min(left + right,res);
        }
        System.out.println(res);
    }

    //获取数组的最长递增子序列
    private static int[] getMaxSub(int[] nums, boolean flag) {
        int n = nums.length;
        //dp[i]以第i个人结尾的最长递增序列
        int[] dp = new int[n];
        Arrays.fill(dp, 1); //最少为1 仅包含他自己
        if (flag) {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // 寻找 nums[0..j-1] 中比 nums[i] 小的元素
                    //将nums[i] 接在最大的nums[j]后面  （nums[i] > nums[j]）
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
        }else {
            for (int i = n - 2; i >= 0; i--) {
                for (int j = n - 1; j > i; j--) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
        }


        return dp;


    }

    /**
     * 考虑情况少了  应该用最小递增子序列来做
     *
     * @param args
     */
    private static void method1() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] hs = new int[n];
        for (int i = 0; i < n; i++) {
            hs[i] = scanner.nextInt();
        }
        int res = Integer.MAX_VALUE;


        for (int i = 1; i < n - 1; i++) {
            int countR = 0;
            //朝两边遍历 每一边两个指针
            //1.右边
            int l = i, r = i + 1;
            while (r <= n - 1) {
                if (hs[r] >= hs[l]) {
                    r++;
                    countR++;
                } else {
                    l = r;
                    r++;
                }
            }
            if (countR == n - 1 - i) {
                continue;
            }

            int countL = 0;
            l = i - 1;
            r = i;
            //2.左边
            while (l >= 0) {
                if (hs[l] >= hs[r]) {
                    l--;
                    countL++;
                } else {
                    r = l;
                    l--;
                }
            }
            if (countL == i) {
                continue;
            }

            res = Math.min(res, countL + countR);
        }

        res = res == Integer.MAX_VALUE ? 0 : res;
        System.out.println(res);

    }


}

