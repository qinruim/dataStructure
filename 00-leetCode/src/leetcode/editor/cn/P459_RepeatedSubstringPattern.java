//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 930 👎 0


package leetcode.editor.cn;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 * 重复的子字符串
 * @author mqinrui
 * @date 2023-04-06 16:44:54
 */
public class P459_RepeatedSubstringPattern{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P459_RepeatedSubstringPattern().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
		/**
		 * 暴力法
		 */
//		int n = s.length();
//		//因为子串至少需要重复一次，所以子串不会大于n 的一半，我们只需要在[1,n/2]的范围内枚举即可。
//		for (int i = 1; i * 2 <= n; ++i) {
//			//假设子字符串长度为i（0～i-1）
//			if (n % i == 0) {
//				boolean match = true;
//				//子串往后的每一个元素j都应该跟（j-i）个元素相同
//				for (int j = i; j < n; ++j) {
//					if (s.charAt(j) != s.charAt(j - i)) {
//						match = false;
//						break;
//					}
//				}
//				if (match) {
//					return true;
//				}
//			}
//		}
//		return false;

		/**
		 * kmp法
		 * 重复子串组成的字符串中，最长相等前后缀不包含的子串就是最小重复子串
		 */
		if (s.length() == 0){
			return false;
		}
		int len = s.length();
		int[] next = new int[len];
		getNext(next,s);
		//1、最长相等前后缀的长度为：next[len - 1] ！= 0,说明字符串有最长相同的前后缀（即有重复部分）
		//2、如果len % (len - (next[len - 1] + 1)) == 0 ，
		//则说明数组的长度正好可以被 (数组长度-最长相等前后缀的长度),即除最长相等前后缀的部分 整除
		//说明该字符串有重复的子字符串。
		if (next[len - 1] != 0 && len % (len - next[len - 1]) == 0){
			return true;
		}
		return false;
	}

	private void getNext(int[] next, String s) {
		int j = 0;
		next[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)){
				j = next[j -1];
			}
			if (s.charAt(i) == s.charAt(j)){
				j++;
			}
			next[i] = j;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
