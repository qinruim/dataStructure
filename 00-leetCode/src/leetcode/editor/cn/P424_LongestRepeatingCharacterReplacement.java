package leetcode.editor.cn;

import java.util.Currency;
import java.util.List;

/**
 * 替换后的最长重复字符
 * @author mqinrui
 * @date 2023-06-26 20:04:45
 */
public class P424_LongestRepeatingCharacterReplacement{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P424_LongestRepeatingCharacterReplacement().new Solution();
	 }

	/**
	 * 初始化一个字符计数器 counter，用于记录窗口内每个字符的出现次数。
	 * 初始化窗口的左边界 left 和右边界 right，初始值都为 0。
	 * 初始化窗口内出现次数最多的字符数 maxCount，初始值为 0。
	 * 遍历字符串 s，将右边界 right 逐步右移：
	 * 在每次右移时，更新字符计数器 counter 中当前字符的出现次数。
	 * 更新 maxCount 为窗口内出现次数最多的字符的出现次数。
	 * 如果窗口长度减去 maxCount 大于 k，说明需要修改超过 k 个字符，窗口不满足条件，需要左移窗口边界 left。
	 * 左移窗口时，更新字符计数器 counter 中窗口左边界字符的出现次数。
	 * 如果窗口左边界字符的出现次数减为 0，从计数器 counter 中移除该字符。
	 * 左移窗口边界 left++。
	 * 计算当前窗口长度 right - left + 1，并更新记录的最大长度 maxLen。
	 * 返回最大长度 maxLen，即包含相同字母的最长子字符串的长度。
	 */
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
		//记录窗口内每个字母出现次数
		int[] count = new int[26];
		//窗口内出现最多的字符的出现次数
		int maxCount = 0;
		int result = 0;
		//初始化左右指针
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			//遍历字符串 s，将右边界 right 逐步右移：
			//在每次右移时，更新字符计数器 counter 中当前字符的出现次数。
			//更新 maxCount 为窗口内出现次数最多的字符的出现次数。
			int curIndex = s.charAt(right) - 'A';
			count[curIndex]++;
			maxCount = Math.max(maxCount,count[curIndex]);

			//如果窗口长度 right - left + 1 减去 maxCount 大于 k，说明需要修改超过 k 个字符，窗口不满足条件，需要右移窗口边界 left,缩小窗口。
			//缩小窗口时，更新字符计数器 count 中窗口左边界字符的出现次数。
			//右移窗口边界 left++
			if ((right - left + 1 - maxCount) > k){
				int leftCharIndex = s.charAt(left) - 'A';
				count[leftCharIndex]--;
				left++;
			}

			result = Math.max(result,right - left + 1);

		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
