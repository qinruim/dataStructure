package leetcode.editor.cn;

import java.io.PipedInputStream;
import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.jar.JarEntry;

/**
 * 不同的子序列
 * distinct-subsequences
 * @author mqinrui
 * @date 2023-08-25 13:12:44
 */
class P115_DistinctSubsequences{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P115_DistinctSubsequences().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 int[][] memo;
    public int numDistinct(String s, String t) {
		int res;
		memo = new int[s.length()][t.length()];
		for (int[] row : memo) {
			Arrays.fill(row,-1);
		}
		// 递归 不同视角
		// s[i.,,,,] 中 t[j,....] 出现次数为 dp（s,i,t,j）
		res = dp(s,0,t,0);

		//自底向上 迭代 动规版本
//		res = getDP(s,t);


		return res;
    }

	/**
	 * 迭代 自底向上  动规版本
	 * @param s
	 * @param t
	 * @return
	 */
	private int getDP(String s, String t) {
		//dp[i][j] s的前i个字符中 t的前j个字符的子序列个数
//		int m = s.length();
//		int n = t.length();
//		int dp[][] = new int[m + 1][n + 1];
//
//		//m < n 肯定没有
//		if (m < n){
//			return 0;
//		}
//		//初始化： dp[0][j]--s_0中t_j的个数 显然是0  只有当j=0 才是1
//		//		 dp[i][0]--s_i中t_0的个数，显然是1
//		for (int i = 0; i <= m; i++) {
//			dp[i][0] = 1;
//		}
//
//		for (int i = 1; i <= m; i++) {
//			for (int j = 1; j <= n; j++) {
//				//在s的角度
//				//若s[i]与t[j] 不匹配 ==>
//				// 那么s_i中的所有t_j子序列，必不包含s[i]，即s_i-1和s_i中tj的数量是一样的
//				if (s.charAt(i - 1) != t.charAt(j - 1)){
//					dp[i][j] = dp[i - 1][j];
//				}else {
//					//若s[i]与t[j] 匹配，
//					// s_i中的所有t_j子序列中，包含s[i]的有a个，不包含的有b个
//					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//				}
//			}
//
//		}
//		return dp[m][n];


		//dp[i][j]定义同递归：s[i,...] 中 t[j...]的个数
		//这样需要从后往前遍历
		int m = s.length();
		int n = t.length();
		if (m < n){
			return 0;
		}

		int[][] dp = new int[m + 1][n + 1];
		//当 j=n时，t[j:]为空字符串，
		//空字符串是任何字符串的子序列，
		for (int i = 0; i <= m; i++) {
			dp[i][n] = 1;
		}
		//当i=m且j<n时，s[i:]为空字符串			dp[m][j] = 0;

		for (int i = m - 1; i >= 0 ; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (s.charAt(i) != t.charAt(j)){
					dp[i][j] = dp[i + 1][j];
				}else {
					dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
				}

			}

		}


		return dp[0][0];
	}

	/**
	 * 两种视角的自顶向下  递归（带memo）
	 * @param s
	 * @param i
	 * @param t
	 * @param j
	 * @return
	 */
	private int dp(String s, int i, String t,int j) {
		//base case  终止条件
		//t[j...]为空字符串
		if (j == t.length()){
			return 1;
		}
		//s[i,...]比t[j,...]还短  不能匹配
		if (s.length() - i < t.length() - j){
			return 0;
		}

		if (memo[i][j] != -1){
			return memo[i][j];
		}

//		int res = 0;

		//视角1 t的视角
		//在s[i,...]中找 s[k]==t[j]
//		for (int k = i; k < s.length(); k++) {
//			if (s.charAt(k) == t.charAt(j)){
//				res += dp(s,k + 1,t,j + 1);
//			}
//		}

		//视角2 s的视角
		if (s.charAt(i) != t.charAt(j)){
			//不能匹配  计算s[1..]中t【0.。。】
//			res += dp(s,i + 1,t,j);
			memo[i][j] = dp(s,i + 1,t,j);
		}else {
			//能匹配  计算两种之和
//			res += (dp(s,i + 1,t,j) + dp(s,i + 1,t,j + 1));
			memo[i][j] = (dp(s,i + 1,t,j) + dp(s,i + 1,t,j + 1));
		}


//		memo[i][j] = res;
		return memo[i][j];




	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
