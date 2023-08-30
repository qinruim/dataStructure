package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 到家的最少跳跃次数
 * @author qr
 * @date 2023-08-30 20:26:37
 */
class P1654_MinimumJumpsToReachHome{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1654_MinimumJumpsToReachHome().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 思路： 从某个位置i出发，将每次跳跃视为边，既一张图
	 * 		找最小跳跃次数 即两个顶点之间的最短路径  可以BFS
	 *
	 * 		具体：
	 * 		还需要注意到达每个坐标时，都会有前进到达还是后退到达两种状态。
	 * 		如果是前进到达时，下一步可以选择前进或者后退；
	 * 		如果是后退到达时，下一步只能选择前进。
	 * 		因此广度优先搜索的每个元素，需要保存三个信息，坐标，方向和步数。
	 * 		在代码中，我们用 1表示前进，−1 表示后退，
	 * 		用哈希集合 visited来记录已经达到过的位置和方向状态。
	 * 		在搜索的过程中，如果坐标第一次为 x，则返回当前步数。
	 * 		当队列为空时，表示 x 不可到达，返回 −1
	 *
	 *
	 * 			无解情况：x在forbidden种
	 * 			还有下一个顶点如果小于0或者在forbidden中 不能跳
	 * 			去重：同一个方向、同一个顶点不用重复搜索
	 *
	 * 			搜索边界： max{f+a+b,x+b}	  否则会无限搜索下去 超时
	 *
	 * @param forbidden
	 * @param a
	 * @param b
	 * @param x
	 * @return
	 */
	public int minimumJumps(int[] forbidden, int a, int b, int x) {
        /**
         * 相当于在queue初始化后，取出一次跳跃的结果，
         * 将其下一次跳跃的结果(前进,根据情况判断此时是否可以后退)加入队列中
         * 然后循环往复，直到 到达x点 || 队列为空
         */

        Queue<int[]> queue = new LinkedList<>();
		// 标记可以到达的点, 正数表示前进到达，负数表示后退到达
		Set<Integer> visited = new HashSet<Integer>();
		// 坐标，方向(1为前进, -1为后退)，步数
		queue.offer(new int[]{0, 1, 0});
		visited.add(0);
		// 定义左右边界 右边界为 max(f + a + b, x + b)
		int lower = 0, upper = 6000;
		Set<Integer> forbiddenSet = new HashSet<Integer>();
		for (int position : forbidden) {
			forbiddenSet.add(position);
		}
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int position = arr[0], direction = arr[1], step = arr[2];
			// 坐标等于x，成功到达目标点
			if (position == x) {
				return step;
			}
			int nextDirection = 1; // 如果下一次方向为前进
			int nextPosition = position + a; // 下一次前进后的坐标
			// 没有超出边界 && 没有前进到达过这个位置 && 这个坐标不是不可到达点
			if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
				// visited 标记这个点(nextPosition)可以前进到达
				visited.add(nextPosition * nextDirection);
				// 在队列中加入前进后到达的点
				queue.offer(new int[]{nextPosition, nextDirection, step + 1});
			}
			// 本次方向是前进，假设下一次是后退
			if (direction == 1) {
				nextPosition = position - b;
				nextDirection = -1;
				// 没有超出边界 && 没有后退到达过这个点 && 这个点不是不可到达点
				if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
					// visited标记 且 加入queue中
					visited.add(nextPosition * nextDirection);
					queue.offer(new int[]{nextPosition, nextDirection, step + 1});
				}
			}
		}
		return -1;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}
