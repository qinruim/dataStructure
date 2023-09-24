//package com.hust.xiaomi;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @Package： com.hust.xiaomi
// * @Title: MI2
// * @Author： qrpop
// * @Date： 2023-09-23 17:20
// * @description:
// */
//public class MI2 {
//
//   static boolean[] visited;
//    static boolean[] onPath;
//    static boolean hasCycle = false;
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String s = scanner.next();
//        String[] strings = s.split(",");
//        for (String string : strings) {
//            String[] aa = string.split(":");
//        }
////        List<Integer>[] graph = buildGraph(n,prerequisites);
//
////        visited = new boolean[numCourses];
////        onPath = new boolean[numCourses];
//
//        //判断是否成环
//        for (int i = 0; i < numCourses; i++) {
//            traverse(graph,i);
////			if (traverse(graph,i)){
////				return false;
////			}
////			Arrays.fill(visited,false);
//        }
//        return !hasCycle;
//    }
//
//
//    private void traverse(List<Integer>[] graph, int i) {
//        if (onPath[i]){
////			return true;
//            hasCycle = true;
//        }
//
//        if (visited[i] || hasCycle){
//            return;
//        }
//
//        visited[i] = true;
//        onPath[i] = true;
//        List<Integer> neighbors = graph[i];
//        for (Integer neighbor : neighbors) {
////			if (traverse(graph,neighbor)){
////				return true;
////			}
//            traverse(graph,neighbor);
//        }
//        onPath[i] = false;
////		return false;
//    }
//
//    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
//        //定义图 ： a 依赖 b  则有一条边 a->b
//        List<Integer>[] graph = new LinkedList[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            graph[i] = new LinkedList<>();
//        }
//        for (int[] pre : prerequisites) {
//            int a = pre[0]; //依赖别人的
//            int b = pre[1]; //被依赖的
//            graph[b].add(a);
//        }
//        return graph;
//    }
//
////    class UF{
////        private int n;
////        private int[] parent;
////
////        public UF(int n) {
////            this.n = n;
////            parent = new int[n];
////
////        }
////    }
//}
