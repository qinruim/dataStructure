package leetcode.editor.cn;

import java.util.*;

/**
 * 滑动谜题
 * sliding-puzzle
 * @author mqinrui
 * @date 2023-09-05 17:03:09
 */
class P773_SlidingPuzzle{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P773_SlidingPuzzle().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int slidingPuzzle(int[][] board) {
		//用一个数组存储棋盘的相对位置
		//neighbor[i]:棋盘中索引为i的棋子相邻棋子的索引{}
//		int[][] neighbor = new int[][]{
//				{1,3},
//				{0,2,4},
//				{1,5},
//				{0,4},
//				{4,2}
//		};

		//构建m*n棋盘的neighbor数组
		int m = board.length;
		int n = board[0].length;
		int[][] neighbor = new int[m * n][];
		for (int i = 0; i < m * n; i++) {
			List<Integer> neighbors = new ArrayList<>();
			//不是第一列 i有左邻居
			if (i % n != 0){
				neighbors.add(i - 1);
			}
			//不是最后一列， i有右邻居
			if (i % n != n - 1){
				neighbors.add(i + 1);
			}
			//不是第一行 有上邻居
			if (i >= n){
				neighbors.add(i - n);
			}
			//不是最后一行，有下邻居
			if (i < (m - 1)*n){
				neighbors.add(i + n);
			}

			neighbor[i] = neighbors.stream().mapToInt(Integer::intValue).toArray();
		}

		/**
		 * BFS
		 */
		String target = "123450";
		//将棋盘转为一维数组作为起点
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(board[i][j]);
			}
		}
		String start = sb.toString();

		int depth = 0;
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		queue.add(start);
		visited.add(start);

		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (target.equals(cur)){
					return depth;
				}
				//找到数字0的索引
				int idx = 0;
				while (cur.charAt(idx) != '0'){
					idx++;
				}

				//将数字0和相邻的数字交换位置 穷举交换后得到的新棋盘（字符串表示）
				for (int index : neighbor[idx]) {
					String newBoard = swap(cur,idx,index);
					if (!visited.contains(newBoard)){
						visited.add(newBoard);
						queue.offer(newBoard);
					}
				}

			}
			depth++;
		}
		return -1;
    }


	private String swap(String cur, int idx, int index) {
		char[] chars = cur.toCharArray();
		char temp = chars[idx];
		chars[idx] = chars[index];
		chars[index] = temp;

		return new String(chars);
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
