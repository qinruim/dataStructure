package leetcode.editor.cn;

import java.util.*;

/**
 * 网络延迟时间
 * @author qr
 * @date 2023-09-24 16:55:04
 */
class P743_NetworkDelayTime{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P743_NetworkDelayTime().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
		//权重和最大的路径
		//1.建图 邻接表 存储每个节点相邻节点 也存一下权重
		List<int[]>[] graph = new LinkedList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] edge : times) {
			int from = edge[0];
			int to = edge[1];
			int weight = edge[2];
			graph[from].add(new int[]{to,weight});
		}

		//2.dijkstra算法计算 节点k为起点到其他节点的最短距离（权重）
		int[] disTo = dijkstra(k,graph);

		//3.返回其中最大的
		int res = 0;
		for (int i = 1; i <= n; i++) {
			if (disTo[i] == Integer.MAX_VALUE){
				//无法收到信号
				return -1;
			}
			res = Math.max(res,disTo[i]);
		}
		return res;
    }

	/**
	 * dij算法
	 * @param start
	 * @param graph
	 * @return
	 */
	private int[] dijkstra(int start, List<int[]>[] graph) {
		int n = graph.length; //节点个数
		int[] disTo = new int[n + 1]; //起点到i节点的最短路径
		Arrays.fill(disTo,Integer.MAX_VALUE);
		disTo[start] = 0;

		PriorityQueue<NODE> pq = new PriorityQueue<>((a,b) -> {
			return a.dis - b.dis;
		});

		pq.offer(new NODE(start,0));
		//从起点开始BFS
		while (!pq.isEmpty()){
			NODE cur = pq.poll();
			int curID = cur.id;
			int curDis = cur.dis;

			if (curDis > disTo[curID]){continue;}
			//相邻节点装入队列 更新最短距离
			for (int[] neighbor : graph[curID]) {
				int nextID = neighbor[0];
				int disToNext = curDis + neighbor[1];
				if (disToNext < disTo[nextID]){
					disTo[nextID] = disToNext; //更新最短距离
					pq.offer(new NODE(nextID,disToNext));
				}
			}
		}
		return disTo;
	}

	class NODE{
		private int id; //图节点编号
		private int dis; //从start到当前节点的距离

		public NODE(int id, int dis) {
			this.id = id;
			this.dis = dis;
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
