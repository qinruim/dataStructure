package leetcode.editor.cn;

import java.util.*;
import java.util.List;

/**
 * 最小体力消耗路径
 * @author qr
 * @date 2023-09-24 17:53:33
 */
class P1631_PathWithMinimumEffort{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1631_PathWithMinimumEffort().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumEffortPath(int[][] heights) {
		int m = heights.length,n = heights[0].length;
		//dp （0，0）到（i，j）的距离
		int[][] distTo = new int[m][n];
		for (int[] row : distTo) {
			Arrays.fill(row,Integer.MAX_VALUE);
		}
		distTo[0][0] = 0;

		Queue<NODE> pq = new PriorityQueue<NODE>((a,b) -> {
			return a.dis - b.dis;
		});
		pq.offer(new NODE(0,0,0));
		while (!pq.isEmpty()){
			NODE cur = pq.poll();
			int curX = cur.x;
			int curY = cur.y;
			int curDis = cur.dis;

			if (curX == m - 1 && curY == n - 1){
				//到达终点
				return curDis;
			}
			//相邻节点 比较距离
			if (curDis > distTo[curX][curY]){
				//当前节点过来的路径权重 比之前的大 不用更新
				//如果相等 那么有可能后续更小 需要更新
				continue;
			}
			//邻居节点加入队列
			List<int[]> neighbors = getNeighbors(curX,curY,heights);
			for (int[] neighbor : neighbors) {
				int nextX = neighbor[0];
				int nextY = neighbor[1];
				int nextDis = Math.max(
						curDis,
						Math.abs(heights[nextX][nextY] - heights[curX][curY])
						);

				//下一个节点是否更新加入队列
				if (nextDis < distTo[nextX][nextY]){
					distTo[nextX][nextY] = nextDis;
					pq.offer(new NODE(nextX,nextY,nextDis));
				}
			}
		}

		//没找到终点 一般不会到这儿
		return -1;
    }

	/**
	 * 获取节点（x，y）的邻居节点坐标的集合
	 * @param curX
	 * @param curY
	 * @param heights
	 * @return
	 */
	int[][] directory = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	private List<int[]> getNeighbors(int curX, int curY, int[][] heights) {
		List<int[]> neighbors = new ArrayList<>();
		int m = heights.length,n = heights[0].length;

		for (int[] dir : directory) {
			int nextX = curX + dir[0];
			int nextY = curY + dir[1];
			//防止越界
			if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n){
				continue;
			}
			neighbors.add(new int[]{nextX,nextY});
		}
		return neighbors;
	}


	 private class NODE {
		//矩阵的一个节点
		private int x,y;
		// 从起点 (0, 0) 到当前位置的最小体力消耗（距离）
		private int dis;

		public NODE(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
}


//leetcode submit region end(Prohibit modification and deletion)

}
