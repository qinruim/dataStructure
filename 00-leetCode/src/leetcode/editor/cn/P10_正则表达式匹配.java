package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 正则表达式匹配
 * regular-expression-matching
 * @author mqinrui
 * @date 2023-10-12 11:07:01
 */
class P10_RegularExpressionMatching{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P10_RegularExpressionMatching().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 private int[][] memo;
    public boolean isMatch(String s, String p) {
		int m = s.length(),n = p.length();
		memo = new int[m][n];
		for (int[] row : memo) {
			Arrays.fill(row,-1);
		}
		return dp(s.toCharArray(),0,p.toCharArray(),0);
    }


	/* 计算 p[j..] 是否匹配 s[i..] */
	private boolean dp(char[] s, int i, char[] p, int j) {
		int m = s.length,n = p.length;

		//base case
		if (j == n){
			//p匹配完了 需要s也刚好匹配完
			return i == m;
		}
		if (i == m){
			//s匹配完了   看p剩下的是否能匹配空串: 普通字符与*成对出现
			if ((n - j) % 2 == 1){
				return false;
			}
			//保证剩下的是偶数个  检查是否是成对出现的形式（x*y*z*）
			while (j + 1 < n){
				if (p[j + 1] != '*'){
					return false;
				}
				j += 2;
			}
			return true;
		}

		//查备忘录
		if (memo[i][j] != -1){
			return memo[i][j] == 1;
		}

		boolean res = false;

		if (s[i] == p[j] || p[j] == '.'){
			//s[i]和p[j]匹配
			if (j < n - 1 && p[j + 1] == '*'){
				//p[j+1]是 * , 即p[j]匹配0次或者多次
				res = dp(s,i,p,j + 2) || dp(s,i + 1,p,j);
			}else {
				//p[j+1]不是 *  就让s[i]和p[j]匹配
				res = dp(s,i + 1,p,j + 1);
			}
		}else {
			//s[i]和p[j]不匹配
			if (j < n - 1 && p[j + 1] == '*'){
				//p[j+1]是 * , * 匹配0次
				res = dp(s,i,p,j + 2);
			}else {
				//无法继续匹配
				res = false;
			}
		}

		//记录
		memo[i][j] = res ? 1 : 0;


		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
