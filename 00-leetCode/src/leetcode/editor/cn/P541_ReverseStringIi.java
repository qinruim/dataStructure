//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 443 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 反转字符串 II
 * @author mqinrui
 * @date 2023-03-29 15:55:37
 */
public class P541_ReverseStringIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P541_ReverseStringIi().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
		//每隔2k个翻转前k个；尾部不够k时全部翻转

		char[] chars = s.toCharArray();
		//注意 i+=2k
		for (int i = 0; i < chars.length; i += 2*k) {
			//保证i+k在数组范围内
			if ((i + k) <= chars.length) {
				//翻转前k个
				reverse(chars, i, i + k - 1);
				continue; //继续外层循环
			}
			//i+k > length  即尾部剩余不足k个，全部翻转
			reverse(chars,i,s.length() - 1);
		}
		return new String(chars);
    }

	private void reverse(char[] chars, int head, int tail) {
		while(head < tail){
			char temp = chars[head];
			chars[head++] = chars[tail];
			chars[tail--] = temp;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
