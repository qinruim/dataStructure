package leetcode.editor.cn;

/**
 * 最长回文子串
 * longest-palindromic-substring
 * @author mqinrui
 * @date 2023-08-30 14:20:05
 */
class P5_LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P5_LongestPalindromicSubstring().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
		if (s.length() == 1){
			return s;
		}
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			//获取长度为偶数的回文串
			String s1 = getPali(s,i,i + 1);
			//获取长度为奇数的回文串
			String s2 = getPali(s,i,i);

			res = res.length() > s1.length() ? res : s1;
			res = res.length() > s2.length() ? res : s2;
		}

		return res;
    }

	private String getPali(String s, int l, int r) {
//		if (l == 0){
//			return s.substring(l,l+1);
//		}
//		if (r == s.length() - 1){
//			return s.substring(r,r+1);
//		}

		while (l >= 0 && r <= s.length() - 1){
			if (s.charAt(l) == s.charAt(r)){
				l--;
				r++;
			}else {
				break;
			}
		}

		//左闭右开  因为l最终会去到-1，r会去到length  所以是 （l+1，r）
		return s.substring(l + 1,r);
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
