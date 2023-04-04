//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
//
// Related Topics 数学 双指针 字符串 👍 379 👎 0


package leetcode.editor.cn;

/**
 * 左旋转字符串
 * @author mqinrui
 * @date 2023-03-31 16:17:18
 */
public class P剑指Offer58_II_ZuoXuanZhuanZiFuChuanLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new Solution();
		  String s = "abcdefg";
		  int k = 2;
		 System.out.println(s);
		 System.out.println(k);
		 System.out.println(solution.reverseLeftWords(s, k));

	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
static class Solution {
    public String reverseLeftWords(String s, int n) {
//		//暴力法
//		//将前n个字符看作一个整体a，剩余字符看作一个整体b，reverse（a，b）
//		//拆成两个字符串  再拼接
//		int length = s.length();
//		char[] chars1 = new char[n];
//		char[] chars2 = new char[length - n];
//
//		char[] chars = s.toCharArray();
//		//第一个字符串，前n个（0 ～ n-1）字符
//		for (int i = 0; i < n; i++) {
//			chars1[i] = chars[i];
//		}
//		//第二个字符串，剩下的字符（n ～ length-1）
//		for (int i = n; i < length; i++) {
//			chars2[i - n] = chars[i];
//		}
//		return new String(chars2) + new String(chars1);

		/**
		 * 法二：不能申请额外空间，只能在本串上操作
		 * 反转区间为前n的子串
		 * 反转区间为n到末尾的子串
		 * 反转整个字符串
		 */
		int length = s.length();
		char[] chars = s.toCharArray();
		reverse(chars,0,n - 1);
		reverse(chars,n,length - 1);
		reverse(chars,0,length - 1);
		return new String(chars);
	}

	private void reverse(char[] chars, int begin, int end) {
		char temp;
		while (begin < end){
			temp = chars[begin];
			chars[begin++] = chars[end];
			chars[end--] = temp;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
