package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



/**
 * 课程表
 * course-schedule
 * @author mqinrui
 * @date 2023-09-20 18:23:53
 */
class P207_CourseSchedule{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P207_CourseSchedule().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 boolean[] visited;
		 boolean[] onPath;
		 boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
		//建立有向图
		List<Integer>[] graph = buildGraph(numCourses,prerequisites);

		visited = new boolean[numCourses];
		onPath = new boolean[numCourses];

		//判断是否成环
		for (int i = 0; i < numCourses; i++) {
			traverse(graph,i);
//			if (traverse(graph,i)){
//				return false;
//			}
//			Arrays.fill(visited,false);
		}
		return !hasCycle;
    }

	private void traverse(List<Integer>[] graph, int i) {
		if (onPath[i]){
//			return true;
			hasCycle = true;
		}

		if (visited[i] || hasCycle){
			return;
		}

		visited[i] = true;
		onPath[i] = true;
		List<Integer> neighbors = graph[i];
		for (Integer neighbor : neighbors) {
//			if (traverse(graph,neighbor)){
//				return true;
//			}
			traverse(graph,neighbor);
		}
		onPath[i] = false;
//		return false;
	}

	private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
		//定义图 ： a 依赖 b  则有一条边 a->b
		List<Integer>[] graph = new LinkedList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] pre : prerequisites) {
			int a = pre[0]; //依赖别人的
			int b = pre[1]; //被依赖的
			graph[b].add(a);
		}
		return graph;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
