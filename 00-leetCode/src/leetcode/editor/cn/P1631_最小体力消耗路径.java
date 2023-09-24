//package leetcode.editor.cn;
//
//import java.time.Year;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * 最小体力消耗路径
// * @author qr
// * @date 2023-09-24 17:53:33
// */
//class P1631_PathWithMinimumEffort{
//	 public static void main(String[] args) {
//	 	 //测试代码
//	 	 Solution solution = new P1631_PathWithMinimumEffort().new Solution();
//	 }
//
////力扣代码
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int minimumEffortPath(int[][] heights) {
//		int m = heights.length;
//		int n = heights[0].length;
//		//1.建图  （x，y）坐标的索引： x*n + y
//		List<int[]>[] graph = new LinkedList[m * n];
//		for (int i = 0; i < m * n; i++) {
//			graph[i] = new LinkedList<>();
//		}
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				int index = i * n + j;
//				graph[index].add(new int[]{})
//			}
//
//		}
//
//		return 1;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}
