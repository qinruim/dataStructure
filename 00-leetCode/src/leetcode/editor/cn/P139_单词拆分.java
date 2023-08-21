package leetcode.editor.cn;

import java.util.List;

/**
 * 单词拆分
 * word-break
 * @author mqinrui
 * @date 2023-08-21 15:57:07
 */
class P139_WordBreak{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P139_WordBreak().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
		/**
		 * 排列 且是找排列的过程中的path 是否能组成s  可以用回溯
		 *
		 * 跟普通完全背包的区别：注意递推方式
		 * s是背包 wordDict是物品集合
		 */
		//dp[i]:字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词
		boolean[] dp = new boolean[s.length() + 1];

		//如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true
		//递推公式是 ： if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true

		//dp[0]就是递推的根基，dp[0]一定要为true，否则递推下去后面都都是false了
		dp[0] = true;

		//遍历顺序:排列
		//背包容量（字符串长度）非空，从1开始
		for (int j = 1; j <= s.length(); j++) {
			//i一定要小于j 否则没有意义（j由i推出来）
			for (int i = 0; i < j; i++) {
				String subString = s.substring(i,j); //截取物品
				if (dp[i] && wordDict.contains(subString)){
					dp[j] = true;
				}
			}
		}

		return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
