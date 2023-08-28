package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到字符串中所有字母异位词
 * @author qr
 * @date 2023-08-28 22:11:30
 */
class P438_FindAllAnagramsInAString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P438_FindAllAnagramsInAString().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 就是在 s 中找子串 使这个子串包含且仅包含 p 的字符
	 * @param s
	 * @param p
	 * @return
	 */
    public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		Map<Character,Integer> window = new HashMap<>();
		Map<Character,Integer> need = new HashMap<>();
		for (char c : p.toCharArray()) {
			need.put(c,need.getOrDefault(c,0) + 1);
		}
		int left = 0,right = 0,valid = 0;

		while (right < s.length()){
			//扩
			char c = s.charAt(right);
			right++;
			if (need.containsKey(c)){
				window.put(c,window.getOrDefault(c,0) + 1);
				if (window.get(c).equals(need.get(c))){
					valid++;
				}
			}

			//缩
			while (right - left == p.length()){
				//更新
				if (valid == need.size()){
					res.add(left);
				}

				char d = s.charAt(left);
				left++;
				if (need.containsKey(d)){
					if (need.get(d).equals(window.get(d))){
						valid--;
					}
					window.put(d,window.get(d) - 1);
				}
			}

		}


		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
