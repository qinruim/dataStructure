package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 * interval-list-intersections
 * @author mqinrui
 * @date 2023-09-04 19:47:03
 */
class P986_IntervalListIntersections{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P986_IntervalListIntersections().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		//用两个索引指针在 A 和 B 中游走，把交集找出来
		int p1 = 0;
		int p2 = 0;

		List<int[]> res = new ArrayList<>();

		while (p1 < firstList.length && p2 < secondList.length){
			int a1 = firstList[p1][0];
			int a2 = firstList[p1][1];
			int b1 = secondList[p2][0];
			int b2 = secondList[p2][1];

			//不相交
			if (a2 < b1){
				p1++;
				continue;
			}else if (b2 < a1){
				p2++;
				continue;
			}

			//相交
			if (a2 >= b1 && b2 >= a1){
				int start = Math.max(a1,b1);
				int end = Math.min(a2,b2);
				res.add(new int[]{start,end});

				if (a2 > b2){
					p2++;
				}else {
					p1++;
				}
			}
		}


		return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
