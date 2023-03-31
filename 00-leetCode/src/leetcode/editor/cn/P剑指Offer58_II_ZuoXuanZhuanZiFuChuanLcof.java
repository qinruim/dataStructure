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
	 	 Solution solution = new P剑指Offer58_II_ZuoXuanZhuanZiFuChuanLcof().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
		//将前n个字符看作一个整体a，剩余字符看作一个整体b，reverse（a，b）
		char[] chars = s.toCharArray();
		char[] newChars = new char[chars.length];

		for (int i = n + 1; i < chars.length; i++) {
			newChars[i - (n + 1)] = chars[i];
		}
		for (int i = 0; i < n; i++) {
			newChars[i + n] = chars[i];
		}

		return new String(newChars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
