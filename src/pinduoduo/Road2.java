package pinduoduo;

import java.util.*;

public class Road2 {
    static List<List<int[]>> graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
        }

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        bfs(1);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = x[i];
            if (dist[cur] % 2 == 0){
                ans++;
            }
        }
        System.out.println(ans);
    }

    //广度优先搜索
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        dist[start] = 0;
        queue.offer(start);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int[] next : graph.get(cur)) {
                int node = next[0];
                int edge = next[1];
                if (!visited[node]){
                    visited[node] = true;
                    if (edge == 1){
                        dist[node] = dist[cur] + 1;
                    }else {
                        dist[node] = dist[cur];
                    }
                    queue.offer(node);
                }

            }

        }
    }
}