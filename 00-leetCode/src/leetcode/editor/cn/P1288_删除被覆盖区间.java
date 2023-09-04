package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 删除被覆盖区间
 * remove-covered-intervals
 * @author mqinrui
 * @date 2023-09-04 18:44:24
 */
class P1288_RemoveCoveredIntervals{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1288_RemoveCoveredIntervals().new Solution();
		  int[][] intervals = new int[2][2];
		  intervals[0] = new int[]{1,4};
		  intervals[1] = new int[]{2,3};
		 System.out.println(solution.removeCoveredIntervals(intervals));
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
		// 按照起点升序排列，起点相同时降序排列
		Arrays.sort(intervals,((o1, o2) -> {
			if (o1[0] == o2[0]){
				return o2[1] - o1[1];
			}
			return o1[0] - o2[0];
		}));

		//因为按照左边界从小到大排序了
		// 因此  只要后面的右边界小于等于前面的和并区间的右边界 就被覆盖了
		//记录合并区间的起止点
		int left = intervals[0][0];
		int right = intervals[0][1];

		int len = intervals.length;
		for (int i = 1; i < intervals.length; i++) {
			//覆盖区间
			if (intervals[i][0] >= left && intervals[i][1] <= right){
				len--;
			}
			//相交区间 合并
			if (intervals[i][1] >= right && intervals[i][0] <= right){
				right = intervals[i][1];
			}
			//分离区间 更新
			if (intervals[i][0] > right){
				left = intervals[i][0];
				right = intervals[i][1];
			}

		}


		return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
