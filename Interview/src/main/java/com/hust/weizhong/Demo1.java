package com.hust.weizhong;

import java.util.*;

/**
 * @Package： com.hust.weizhong
 * @Title: Demo1
 * @Author： qrpop
 * @Date： 2023-09-13 20:30
 * @description: 去重
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();//珠子数量
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = scanner.nextInt();
        }

        int p = n - 1;
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0 ; i--) {
            if (set.contains(color[i])){
                continue;
            }
            set.add(color[i]);
            res.add(color[i]);
        }

        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i) + " ");
        }


    }
}
