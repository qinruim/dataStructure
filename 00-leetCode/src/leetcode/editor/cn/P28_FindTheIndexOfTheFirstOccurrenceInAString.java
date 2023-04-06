//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
//
//
// 示例 2：
//
//
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= haystack.length, needle.length <= 10⁴
// haystack 和 needle 仅由小写英文字符组成
//
//
// Related Topics 双指针 字符串 字符串匹配 👍 1818 👎 0


package leetcode.editor.cn;

/**
 * 找出字符串中第一个匹配项的下标
 * @author mqinrui
 * @date 2023-04-04 16:47:23
 */
public class P28_FindTheIndexOfTheFirstOccurrenceInAString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P28_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 //不-1的版本
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) return 0;
		int[] next = new int[needle.length()];
		getNext(next, needle);
		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {
			while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
				j = next[j - 1];
			}
			if (needle.charAt(j) == haystack.charAt(i)) {
				j++;
			}
			if (j == needle.length()) {
				return i - needle.length() + 1;
			}
		}
		return -1;
	}
	private void getNext(int[] next, String s) {
		int j = 0;
		next[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			while (j > 0 && s.charAt(j) != s.charAt(i)) {
				j = next[j - 1];
			}
			if (s.charAt(j) == s.charAt(i)) {
				j++;
			}
			next[i] = j;
		}
	}
//    public int strStr(String haystack, String needle) {
//		//暴力匹配 两个for循环
//		/**
//		 * kmp算法
//		 */
//		if (needle.length() == 0){
//			return 0;
//		}
//		int n = haystack.length();
//		int m = needle.length();
//		int[] next = new int[m];
//		getNext(next,needle);
//
//		//用next数组做匹配
//		//定义两个下标，j指向模式串起始位置，i指向文本串起始位置。
//		//j初始值依然为-1，因为next数组里记录的起始位置为-1
//		int j = -1;
//		for (int i = 0; i < n; i++) {
//			//s[i] 与 t[j + 1] （因为j从-1开始的） 进行比较。
//			//如果 s[i] 与 t[j + 1] 不相同，j就要从next数组里寻找下一个匹配的位置
//			while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)){
//				j = next[j];
//			}
//			//如果 s[i] 与 t[j + 1] 相同，那么i 和 j 同时向后移动
//			if (haystack.charAt(i) == needle.charAt(j + 1)){
//				j++;
//			}
//			//如果j指向了模式串t的末尾，那么就说明模式串t完全匹配文本串s里的某个子串了。
//			if (j == m - 1){
//				return i - m + 1;
//			}
//		}
//
//		return -1;
//    }

	/**
	 * 构造next数组，实际就是计算模式串s的前缀表
	 * @param next
	 * @param s
	 * @return
	 */
//	private void getNext(int[] next, String s) {
//		//1、初始化
//		//定义两个指针i和j，j指向前缀末尾位置，i指向后缀末尾位置。然后还要对next数组进行初始化赋值
//		//next[i] 表示 i（包括i）之前最长相等的前后缀长度（其实就是j）
//		int j = -1;
//		next[0] = j;
//
//		//因为j初始化为-1，那么i就从1开始，进行s[i] 与 s[j+1]的比较。(前缀j+1 从0开始，后缀i从1开始)
//		//next[j]就是记录着j（包括j）之前的子串的相同前后缀的长度。
//		//那么 s[i] 与 s[j+1] 不相同，就要找 j+1前一个元素在next数组里的值（就是next[j]）。
//		for (int i = 1; i < s.length(); i++) {
//			//2、处理前后缀不同的情况,回退。while，回退到找到相等元素为止
//			while (j >= 0 && s.charAt(i) != s.charAt(j + 1)){
//				j = next[j];
//			}
//			//3、处理前后缀相同的情况,i,j后移即可
//			if (s.charAt(i) == s.charAt(j + 1)){
//				j++; //i++在for循环
//			}
//			//i++后更新next数组
//			next[i] = j;  // 将j（前缀的长度）赋给next[i]
//		}
//	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
