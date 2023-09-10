package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 鸡蛋掉落
 * @author qr
 * @date 2023-09-10 21:13:57
 */
class P887_SuperEggDrop{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P887_SuperEggDrop().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int[][] memo;

	public int superEggDrop(int k, int n) {
		//1.自顶向下 记忆化递归
		return method1(k,n);
    }

	private int method1(int k, int n) {
		memo = new int[k + 1][n + 1];
		for (int[] row : memo) {
			Arrays.fill(row,-999);
		}
		return dp(k,n);
	}

	// 定义：手握 K 个鸡蛋，面对 N 层楼，最少的扔鸡蛋次数为 dp(K, N)
	private int dp(int k, int n) {
		//base case
		if (k == 1){
			return n;
		}
		if (n == 0){
			return 0;
		}
		//检查备忘录
		if (memo[k][n] != -999){
			return memo[k][n];
		}

		int res = Integer.MAX_VALUE;
		//从一楼开始尝试
//		for (int i = 1; i <= n; i++) {
//			res = Math.min(res,Math.max(dp(k - 1,i - 1),dp(k,n - i)) + 1); //碎和没碎 然后+1
//		}
		//状态转移方程的函数图像具有单调性，可以二分搜索快速找到最值
		int lo = 1, hi = n;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			// 鸡蛋在第 mid 层碎了和没碎两种情况
			int broken = dp(k - 1, mid - 1);
			int not_broken = dp(k, n - mid);
			// res = min(max(碎，没碎) + 1)
			if (broken > not_broken) {
				hi = mid - 1;
				res = Math.min(res, broken + 1);
			} else {
				lo = mid + 1;
				res = Math.min(res, not_broken + 1);
			}
		}
		memo[k][n] = res;
		return memo[k][n];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
