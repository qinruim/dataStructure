package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * @author qr
 * @date 2023-08-28 20:47:01
 */
class P76_MinimumWindowSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P76_MinimumWindowSubstring().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
		Map<Character,Integer> window = new HashMap<>();
		Map<Character,Integer> need = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			need.put(c,need.getOrDefault(c,0) + 1);
//			need.put(c, need.containsKey(c) ? need.get(c) + 1 : 1);
		}
//		for (int i = 0; i < s.length(); i++) {
//			window.put(s.charAt(i),0);
//		}

		int left = 0,right = 0;
		int valid = 0; //窗口中满足need要求的字符的个数  当valid==need.size 即找到了一个字串

		int len = s.length();
		//记录最小覆盖子串起始索引和长度
		int start = 0,subLen = Integer.MAX_VALUE;

		while (right < len){
				char c = s.charAt(right);
				//扩大窗口
				right++;
				if (need.containsKey(c)){
					//记录窗口中满足要求的字符
					window.put(c, window.getOrDefault(c,0) + 1);
					//当该字符满足要求（窗口中个数和need中个数相同）
					if (window.get(c).equals(need.get(c))){
						valid++;
					}
				}

				//判断是否该缩小窗口
				while (valid == need.size()){
					//更新最小覆盖子串
					if (right - left < subLen){
						start = left;
						subLen = right - left;
					}

					char d = s.charAt(left);
					left++;
					if (need.containsKey(d)){
						//保证只减一次
						if (window.get(d).equals(need.get(d))){
							valid--;
						}
						window.put(d, window.get(d) - 1);
					}
				}


		}

		//如果没有子串，right就会一直扩 直接结束 sunLen不会变
		return subLen == Integer.MAX_VALUE ? "" : s.substring(start,start + subLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
