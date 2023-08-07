package leetcode.editor.cn;

/**
 * 斐波那契数
 * fibonacci-number
 * @author mqinrui
 * @date 2023-08-07 17:12:33
 */
class P509_FibonacciNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P509_FibonacciNumber().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {

		int[] dp = new int[n + 1];
		if (n < 2){
			return n;
		}

		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
