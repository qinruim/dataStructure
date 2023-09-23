package com.hust.mairui;

import java.util.*;

/**
 * @Package： com.hust.mairui
 * @Title: Demo
 * @Author： qrpop
 * @Date： 2023-09-23 10:55
 * @description:
 */
public class Demo {
    static boolean[] used;
    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> result = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine(); // 输入问题，nextline()在前面

        String[] strings = s.split(" ");
        List<Integer> nums = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            int num = Integer.parseInt(strings[i]);
            if (nums.contains(num)){
                continue;
            }
            nums.add(num);
        }
        int n = nums.size();
        used = new boolean[n];
        backTracking(nums, n, k);
        for (List<Integer> p : result) {
            System.out.println(p.toString());
        }
    }

    public static void backTracking(List<Integer> nums, int n, int k){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(used[i]) {
                continue;
            }
            path.add(nums.get(i));
            used[i] = true;
            backTracking(nums, n, k);
            path.removeLast();
            used[i] = false;
        }
    }
}
