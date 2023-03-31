//给你一个字符串 s ，请你反转字符串中 单词 的顺序。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。 
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。 
//
// Related Topics 双指针 字符串 👍 813 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 反转字符串中的单词
 * @author mqinrui
 * @date 2023-03-31 11:28:01
 */
public class P151_ReverseWordsInAString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P151_ReverseWordsInAString().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
		//用api
//		String[] s1 = s.trim().split("\\s+");
//		List<String> list = Arrays.asList(s1);
//		Collections.reverse(list);
//		return  String.join(" ",list);

		//先把整个字符串翻转，遍历一遍把每个单词翻转即可
		char[] chars = s.toCharArray();
		//1.移除首尾和中间多余空格
		chars = removeExtraSpaces(chars);
		//2.翻转整个字符串
		reverse(chars,0,chars.length - 1);
		//3.翻转每个单词
		reverseEachWord(chars);
		return new String(chars);
    }

	/**
	 * 翻转每个单词 在每个单词内部进行翻转字符串
	 * @param chars
	 */
	private void reverseEachWord(char[] chars) {
		//遍历出一个单词 单词开始索引为left,单词结束索引为right
		int left = 0;
		//end <= s.length() 这里的 = ，是为了让 end 永远指向单词末尾后一个位置，这样 reverse 的实参更好设置
		for (int right = 0; right <= chars.length; right++) {
			//这个if两个条件不能交换位置（原因不明）
			if (right == chars.length || chars[right] == ' '){
				reverse(chars,left,right - 1);
				left = right + 1;
			}
		}
	}

	/**
	 * 翻转整个字符串(左闭右闭)
	 * @param chars
	 * @param left
	 * @param right
	 */
	private void reverse(char[] chars, int left, int right) {

		while (left < right){
			char temp = chars[left];
			chars[left++] = chars[right];
			chars[right--] = temp;
		}
	}

	/**
	 * 快慢指针移除空格 思路参考P27 移除元素
	 * @param chars
	 */
	private char[] removeExtraSpaces(char[] chars) {
		int slowIndex = 0;
		for (int fastIndex = 0; fastIndex < chars.length; fastIndex++) {
			//快指针指向旧数组，慢指针指向新数组，不为空格就把快指针的值给慢指针，即完成去除空格操作
			//遇到空格就处理，即删除所有空格
			if (chars[fastIndex] != ' '){
				//手动控制空格，给单词之间加上空格。slow != 0 说明不是第一个单词，需要在单词前添加空格。
				if (slowIndex != 0){
					chars[slowIndex++] = ' ';
				}
				//补上该单词，遇到空格说明单词结束。
				while (fastIndex < chars.length && chars[fastIndex] != ' '){
					chars[slowIndex++] = chars[fastIndex++];
				}
			}
		}
		//相当于c++的resize（）
		char[] newChars = new char[slowIndex];
		System.arraycopy(chars,0,newChars,0,slowIndex);
		return newChars;


	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
