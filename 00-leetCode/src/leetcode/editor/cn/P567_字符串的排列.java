package leetcode.editor.cn;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串的排列
 * @author qr
 * @date 2023-08-28 21:49:28
 */
class P567_PermutationInString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P567_PermutationInString().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 即找到s2的一个子串  该字串包含且仅包含s1的所有字符
	 * @param s1
	 * @param s2
	 * @return
	 */
    public boolean checkInclusion(String s1, String s2) {
		Map<Character, Integer> window = new HashMap<>();
		Map<Character, Integer> need = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			need.put(c,need.getOrDefault(c,0) + 1);
		}

		int left = 0,right = 0;
		int valid = 0;

		while (right < s2.length()){
			//扩
			char c = s2.charAt(right);
			right++;
			if (need.containsKey(c)){
				window.put(c, window.getOrDefault(c,0) + 1);
				if (window.get(c).equals(need.get(c))){
					valid++;
				}
			}

			//缩   子串长度一定 == s1.length  所以其实是一相等就缩  维护一个定长的窗口  因此这个while用if也行
			if (right - left == s1.length()){
				//更新 在定长的窗口内 一旦窗口符合要求 即找到了
				if (valid == need.size()){
					return true;
				}
				char d = s2.charAt(left);
				left++;
				if (need.containsKey(d)){
					if (window.get(d).equals(need.get(d))){
						valid--;
					}
					window.put(d, window.get(d) - 1);
				}
			}
		}
		return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
