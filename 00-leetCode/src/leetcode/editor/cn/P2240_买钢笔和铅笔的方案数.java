package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 买钢笔和铅笔的方案数
 * number-of-ways-to-buy-pens-and-pencils
 * @author mqinrui
 * @date 2023-09-01 16:00:06
 */
class P2240_NumberOfWaysToBuyPensAndPencils{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2240_NumberOfWaysToBuyPensAndPencils().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

//		if (cost1 > total && cost2 > total){
//			return 1;
//		}
//
//		long res = 0;
//		int n1 = total / cost1;
////		int n2 = total / cost2;
//
//		//i 是钢笔数量
//		for (int i = 0; i <= n1; i++) {
//			res += (total - i * cost1) / cost2 + 1;
//		}
//
//		return res;

		//2,背包解法
		return bag(total,cost1,cost2);
    }

	private long bag(int total, int cost1, int cost2) {
		//dp[j]: 容量为j 的方案数
		long[] dp = new long[total + 1];
		Arrays.fill(dp,1);
		int[] costs = new int[]{cost1,cost2};

		for (int cost : costs) {
			for (int j = cost; j <= total; j++) {
				dp[j] += dp[j - cost];

			}

		}



		//不买也算一种 +1
		return dp[total];

	}


}
//leetcode submit region end(Prohibit modification and deletion)


}
