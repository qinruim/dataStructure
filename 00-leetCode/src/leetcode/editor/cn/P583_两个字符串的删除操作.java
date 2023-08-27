package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 两个字符串的删除操作
 * @author qr
 * @date 2023-08-27 21:50:06
 */
class P583_DeleteOperationForTwoStrings{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P583_DeleteOperationForTwoStrings().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 int[][] memo;
    public int minDistance(String word1, String word2) {

		//就是计算最长公共子序列  lcs  ，return (n - lcs) + (m - lcs)
		int len1 = word1.length(),len2 = word2.length();
		memo = new int[len1][len2];
		for (int[] row : memo) {
			Arrays.fill(row,-1);
		}

		//dp(s1,i,s2,j)  s1[i,...] 和 s2[j,...] 的最长 公共子序列
		int lcs = dp(word1,0,word2,0);

		return len1 - lcs + len2 - lcs;
    }

	private int dp(String s1, int i, String s2, int j) {
		if (i == s1.length() || j == s2.length()){
			return 0;
		}

		if (memo[i][j] != -1){
			return memo[i][j];
		}

		if (s1.charAt(i) == s2.charAt(j)){
			memo[i][j] = 1 + dp(s1,i + 1,s2,j + 1);
		}else {
			memo[i][j] = Math.max(dp(s1,i,s2,j + 1),dp(s1,i + 1,s2,j));
		}

		return memo[i][j];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
