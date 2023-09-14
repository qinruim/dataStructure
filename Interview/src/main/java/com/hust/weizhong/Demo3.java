package com.hust.weizhong;

import sun.management.counter.LongCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package： com.hust.weizhong
 * @Title: Demo3
 * @Author： qrpop
 * @Date： 2023-09-13 20:56
 * @description:
 */
public class Demo3 {
    private  static int n;
    private static int m;
    private static int t;
    private static List<Integer>[] lines;
    private static boolean[] visited;
    private static boolean[] isLoop;

    private static long count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); //岛屿数量
        m = scanner.nextInt();//航班数量
        int s = scanner.nextInt();//起点
        t = scanner.nextInt();//目的地
        lines = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lines[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        isLoop = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            lines[x].add(y);
            lines[y].add(x);
        }

        dfs(s);

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            isLoop = new boolean[n + 1];

            visited[s] = true;
            if (i == s || i == t){
                continue;
            }else {
                dfs11(i);
            }

        }

        System.out.println(count);





    }

    private static void dfs(int s) {
       if (visited[s] || isLoop[s] || s == t){
            return;
       }
       if (s != t) count++;
       visited[s] = true;
       isLoop[s] = true;
        for (Integer i : lines[s]) {
            dfs(i);
        }
        isLoop[s] = false;
    }

    private static void dfs11(int s) {
        if (visited[s] || isLoop[s]){
            return;
        }
        if (s == t) {
            count++;
            return;
        }
        visited[s] = true;
        isLoop[s] = true;
        for (Integer i : lines[s]) {
            dfs11(i);
        }
        isLoop[s] = false;
    }
}




