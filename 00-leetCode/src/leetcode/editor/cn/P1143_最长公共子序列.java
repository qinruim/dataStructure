package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最长公共子序列
 * @author qr
 * @date 2023-08-27 21:04:17
 */
class P1143_LongestCommonSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1143_LongestCommonSubsequence().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
		//1.自顶向下（带备忘录递归）
		// dp 函数的定义是：dp(s1, i, s2, j) 计算 s1[i..] 和 s2[j..] 的最长公共子序列长度。
		memo = new int[text1.length()][text2.length()];
		for (int[] row : memo) {
			Arrays.fill(row,-1);
		}
		int res;
//		res = dp(text1,0,text2,0);

		//2.自底向上
		res = dp2(text1,text2);

		return res;
    }

	/**
	 * 自底向上
	 * @param s1
	 * @param s2
	 * @return
	 */
	private int dp2(String s1, String s2) {
		int len1= s1.length(),len2 = s2.length();
		//dp[i][j]：s1[0,...i-1],和s2[0,...j-1]的最长公共子序列
		int[][] dp = new int[len1 + 1][len2 + 1];

		//初始化base case  s1为空或者s2为空 对应dp[i][0]和dp[0][j] 都为0

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)){
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}else {
					dp[i][j] = max(
							dp[i - 1][j],
							dp[i][j - 1],
							dp[i - 1][j - 1]
					);
				}

			}

		}

		return dp[len1][len2];
	}

	/**
	 * 自顶向下带备忘录
	 * @param s1
	 * @param i
	 * @param s2
	 * @param j
	 * @return
	 */
	private int dp(String s1, int i, String s2, int j) {
		//base case
		if (i == s1.length() || j == s2.length()){
			return 0;
		}

		//查备忘录
		if (memo[i][j] != -1){
			return memo[i][j];
		}

		//如果 s1[i] == s2[j]，说明这个字符一定在 lcs 中
		// 加上 s1[i+1..] 和 s2[j+1..] 中的 lcs 长度，就是答案
		if (s1.charAt(i) == s2.charAt(j)){
//			return 1 + dp(s1,i + 1,s2,j + 1);
			memo[i][j] = 1 + dp(s1,i + 1,s2,j + 1);
		}else {
			//s1[i] != s2[j] 意味着，s1[i] 和 s2[j] 中至少有一个字符不在 lcs 中：

			//1.两个都不在 2.s1[i]不在 3.s2[j]不在
			//两个都不在其实被另两种包含，可以去掉
//			int res;
//			memo[i][j] = max(
//					dp(s1,i + 1,s2,j + 1),
//					dp(s1,i + 1,s2,j),
//					dp(s1,i,s2,j+1)
//			);
			memo[i][j] = Math.max(dp(s1,i + 1,s2,j),dp(s1,i,s2,j+1));

		}
		return memo[i][j];
	}

	private int max(int a,int b,int c){
		return Math.max(Math.max(a,b),c);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
