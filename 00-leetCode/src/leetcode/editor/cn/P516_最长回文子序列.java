package leetcode.editor.cn;

/**
 * 最长回文子序列
 * @author qr
 * @date 2023-08-27 20:57:32
 */
class P516_LongestPalindromicSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P516_LongestPalindromicSubsequence().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
		int len = s.length();
		//在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
		int[][] dp = new int[len][len];

		//base case  只有一个字符（i == j）  结果是1
		// 且j >= i  对j<i的情况 一定不存在回文串
		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}

		//初始是对角线 且下半部分没有意义   必须从下往上 从左往右遍历
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}else {
					//二者不等 说明他们俩不能同时出现在回文串中  分别加入，取大的
					dp[i][j] = Math.max(
							dp[i][j - 1], //加入i
							dp[i + 1][j]
					);
				}
			}
		}



		return dp[0][len - 1] ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
