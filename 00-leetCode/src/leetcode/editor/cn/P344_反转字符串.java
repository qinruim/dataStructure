package leetcode.editor.cn;

/**
 * 反转字符串
 * reverse-string
 * @author mqinrui
 * @date 2023-08-30 14:14:16
 */
class P344_ReverseString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P344_ReverseString().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
		int left = 0,right = s.length - 1;

		while (left < right){
//			swap(s[left],s[right]);
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}

    }

	private void swap(char c1, char c2) {
		char temp = c1;
		c1 = c2;
		c2 = temp;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
