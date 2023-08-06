package xiaohongshu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 小红在刷小红书的时候看到了一颗挂着小红薯的小红树，所以小红也想种一颗小红树挂一些小红薯发小红书。
 * 小红有一颗树，每个结点有一个权值，初始时每个节点都是白色。
 * 小红每次操作可以选择两个相邻的结点，如果它们都是白色且权值的和是质数，小红就可以选择其中一个节点染红。
 * 小红想知道最多可以染红多少个节点？
 *
 * 输入：第一行输入一个正整数n，代表节点的数量。
 * 第二行输入n个正整数ai，代表每个节点的权值。
 * 接下来的n-1行，每行输入两个正整数u,v，代表节点u和节点v有一条边连接。
 * 1≤n ≤ 105
 * 1≤ ai ≤ 105
 * 1≤ u,v ≤ n
 *
 * 输出：输出一个整数表示答案。
 */
public class RedTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();;
            int v = scanner.nextInt();;
            List<Integer> edge = new ArrayList<>();
            edge.add(u);
            edge.add(v);
            edges.add(edge);
        }

        getMostRedNodes(n,weights,edges);
    }

    private static void getMostRedNodes(int n, int[] weights, List<List<Integer>> edges) {
        HashMap<Integer, List<Integer>> connectMap = new HashMap<>();
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            connectMap.putIfAbsent(u, new ArrayList<>());
            connectMap.putIfAbsent(v, new ArrayList<>());
            connectMap.get(u).add(v);
            connectMap.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int maxRed = dfs(1,-1,connectMap,weights,visited);

    }

    private static int dfs(int curr, int i1, HashMap<Integer, List<Integer>> connectMap, int[] weights, boolean[] visited) {
        int resCount = 0;

        if(!visited[i])



    }
}
