package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * @author qr
 * @date 2023-08-06 10:30:19
 */
class P3_LongestSubstringWithoutRepeatingCharacters{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> window = new HashMap<>();

		int left = 0,right = 0;
		int subLen = 0;

		while (right < s.length()){
			//扩: 还未出现重复字符
			char c = s.charAt(right);
			right++;
			window.put(c,window.getOrDefault(c,0) + 1);

			//缩：有重复字符
			while (window.get(c) > 1){
				//更新
//				subLen = Math.max(subLen,right - left);

				char d = s.charAt(left);
				left++;
				window.put(d,window.get(d) - 1);
			}
			//保证在没有重复字符时才更新（在扩大窗口时更新）
			subLen = Math.max(subLen,right - left);
		}

		return subLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
