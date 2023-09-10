package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 合并区间
 * merge-intervals
 * @author mqinrui
 * @date 2023-09-04 17:25:06
 */
class P56_MergeIntervals{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P56_MergeIntervals().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals,(o1,o2) -> {
			return o1[0] - o2[0];
		});

		int left = intervals[0][0];
		int right = intervals[0][1];

		LinkedList<int[]> list = new LinkedList<>();

		list.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			//重叠 合并
			if (intervals[i][0] <= right){
				right = Math.max(right,intervals[i][1]);
				list.removeLast();
				list.add(new int[]{left,right});
			}
			//不重叠 更新
			if (intervals[i][0] > right){
				left = intervals[i][0];
				right = intervals[i][1];
				list.add(new int[]{left,right});
			}

		}

		int[][] res = list.toArray(new int[list.size()][]);

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
