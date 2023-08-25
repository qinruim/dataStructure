package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题
 * russian-doll-envelopes
 * @author mqinrui
 * @date 2023-08-24 16:43:43
 */
class P354_RussianDollEnvelopes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P354_RussianDollEnvelopes().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
		/**
		 * 相当于在二维平面中找最长子序列
		 *
		 * 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序；
		 * 之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
		 *原因：
		 * 首先，对宽度 w 从小到大排序，确保了 w 这个维度可以互相嵌套，
		 * 所以我们只需要专注高度 h 这个维度能够互相嵌套即可。
		 *其次，两个 w 相同的信封不能相互包含，所以对于宽度 w 相同的信封，对高度 h 进行降序排序，
		 * 保证二维 LIS 中不存在多个 w 相同的信封（因为题目说了长宽相同也无法嵌套）。
		 */
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				//    宽度相同就按照高度逆序排              否则，就按宽度顺序排
				return o1[0] == o2[0] ? o2[1] - o1[1] : o1[1] - o2[1];
			}
		});

		//在高度里面找最长子序列
		int len = envelopes.length;
		int res = 0;
		int[] dp = new int[len];
		Arrays.fill(dp,1);
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[j][1] < envelopes[i][1]){
					dp[i] = Math.max(dp[i],dp[j] + 1);
				}
			}
			res = Math.max(res,dp[i]);
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
