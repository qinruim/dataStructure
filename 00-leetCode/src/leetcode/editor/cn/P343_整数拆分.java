package leetcode.editor.cn;

/**
 * 整数拆分
 * @author qr
 * @date 2023-08-11 22:21:11
 */
class P343_IntegerBreak{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P343_IntegerBreak().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {

		//dp[i] 为正整数 i 拆分后的几个数的最大乘积
		int[] dp = new int[n + 1];

		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			//j 最大不超过i的一半，比如6，到3之后都是重复的
			for (int j = 1; j <= (i >> 1); j++) {
				// j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
				//而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
				dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i - j]));
			}
		}


		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
