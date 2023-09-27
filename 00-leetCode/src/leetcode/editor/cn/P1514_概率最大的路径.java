package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 概率最大的路径
 * path-with-maximum-probability
 * @author mqinrui
 * @date 2023-09-25 13:57:23
 */
class P1514_PathWithMaximumProbability{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1514_PathWithMaximumProbability().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		//1.建图 存放每个节点的相邻节点和对应的权重
		List<double[]>[] graph = buildGraph(n,edges,succProb);

		//Dijkstra
		//从start到i的最大概率（权重）
		double[] disTo = new double[n];
		Arrays.fill(disTo,-1);
		disTo[start_node] = 1.0;

		PriorityQueue<NODE> pq = new PriorityQueue<NODE>((a,b) -> {
//			return (int) (b.dis - a.dis);
			return Double.compare(b.dis,a.dis);
		});
		pq.offer(new NODE(start_node,1));
		while (!pq.isEmpty()){
			NODE cur = pq.poll();
			int curID = cur.id;
			double curDis = cur.dis;
			//到达终点
			if (curID == end_node){
				return curDis;
			}
			//不必更新
			if (curDis < disTo[curID]){
				continue;
			}

			List<double[]> neighbors = graph[curID];
			for (double[] neighbor : neighbors) {
				int nextId = (int) neighbor[0];
				double nextDis = disTo[curID] * neighbor[1];
				if (nextDis > disTo[nextId]){
					disTo[nextId] = nextDis;
					pq.offer(new NODE(nextId,nextDis));
				}
			}
		}

		return 0.0;
    }

	private List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
		List<double[]>[] graph = new LinkedList[n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0;i < edges.length;i++) {
			int node1 = edges[i][0];
			int node2 = edges[i][1];
			graph[node1].add(new double[]{(double) node2,succProb[i]});
			graph[node2].add(new double[]{(double) node1,succProb[i]});
		}
		return graph;
	}

	/**
	 * 记录节点id和//从start到当前节点的权重
	 */
	private class NODE {
		private int id;
		private double dis;

		public NODE(int id, double dis) {
			this.id = id;
			this.dis = dis;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
