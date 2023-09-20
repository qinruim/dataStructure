package leetcode.editor.cn;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 课程表 II
 * course-schedule-ii
 * @author mqinrui
 * @date 2023-09-20 19:23:42
 */
class P210_CourseScheduleIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P210_CourseScheduleIi().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 boolean[] visited;
		 boolean[] onPath;
		 boolean hasCycle = false;
		 LinkedList<Integer> res = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = buildGraph(numCourses,prerequisites);
		//DFS版本
//		return method1(numCourses,prerequisites,graph);

		//BFS版本
		return method2(numCourses,prerequisites,graph);



    }

	private int[] method2(int numCourses, int[][] prerequisites, List<Integer>[] graph) {
		int[] res = new int[numCourses];
		//入度数组
		int[] inDegree = new int[numCourses];
		for (int[] edge : prerequisites) {
			inDegree[edge[0]]++;
		}

		//根据入度初始化队列中的节点
		Deque<Integer> q = new LinkedList<>();
		int count = 0; //入队节点个数
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0){
				// 节点 i 入度为0，即没有依赖的节点
				// 可以作为拓扑排序的起点，加入队列
				q.offer(i);
			}
		}
		while (!q.isEmpty()){
			int cur = q.poll();
			res[count++] = cur;
			List<Integer> neighbors = graph[cur];
			for (Integer neighbor : neighbors) {
				if (--inDegree[neighbor] == 0){
					q.offer(neighbor);
				}
			}
		}

		if (count != numCourses){
			//成环
			return new int[]{};
		}
		return res;

	}

	private int[] method1(int numCourses, int[][] prerequisites, List<Integer>[] graph) {
		visited = new boolean[numCourses];
		onPath = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			traversal(graph,i);
		}

		if (hasCycle){
			return new int[]{};
		}


		//后序遍历结果反转就是拓扑排序
//		Collections.reverse(res);
		int[] resArray = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
//			resArray[i] = res.get(i);
			resArray[i] = res.get(numCourses - 1 - i);
		}
		return resArray;

	}

	private void traversal(List<Integer>[] graph, int i) {
		if (onPath[i]){
			hasCycle = true;
			return;
		}

		if (visited[i] || hasCycle){
			return;
		}

		visited[i] = true;
		onPath[i] = true;
		List<Integer> neighbors = graph[i];
		for (Integer neighbor : neighbors) {
			traversal(graph,neighbor);
		}

		res.add(i); //记录后序遍历结果
		onPath[i] =false;
	}

	private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new LinkedList[numCourses];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] pre : prerequisites) {
			int from = pre[1];
			int to = pre[0];
			graph[from].add(to);
		}

		return graph;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
