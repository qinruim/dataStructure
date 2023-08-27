package leetcode.editor.cn;

/**
 * 让字符串成为回文串的最少插入次数
 * @author qr
 * @date 2023-08-27 23:21:32
 */
class P1312_MinimumInsertionStepsToMakeAStringPalindrome{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1312_MinimumInsertionStepsToMakeAStringPalindrome().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minInsertions(String s) {
		//还有一种方法：
		// 可以找到最长回文子串长度slcs    return len - lcs 即可


		int len = s.length();

		//dp[i][j] : 字串s[i,...j] 的操作次数
		int[][] dp = new int[len][len];

		//base case
		//只有一个字符，不用操作：dp[i][i] = 0   j<i没有意义 置为0

		for (int i = len - 1; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)){
					//二者相等，不需要操作
					dp[i][j] = dp[i + 1][j - 1];
				}else {
					//二者不等  可能是左边插入、右边插入
					dp[i][j] = 1 + Math.min(
							dp[i + 1][j], //右边插入
							dp[i][j - 1]  //左边插入
					);
				}
			}
		}

		return dp[0][len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
