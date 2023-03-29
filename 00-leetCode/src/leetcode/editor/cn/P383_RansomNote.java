//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 682 👎 0


package leetcode.editor.cn;

/**
 * 赎金信
 * @author mqinrui
 * @date 2023-03-29 11:01:10
 */
public class P383_RansomNote{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P383_RansomNote().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		//哈希法
		//定义一个哈希映射数组
		int[] record = new int[26];

		//遍历
		// 记录mag字符串中字母出现次数
		for (char c : magazine.toCharArray()) {
			record[c - 'a'] += 1;
		}
		// ran字符串中出现字母去匹配，出现一次则-1
		for (char c : ransomNote.toCharArray()) {
			record[c - 'a'] -= 1;
		}

		//如果record数组中出现负值，说明ran中存在mag没有的字母，返回false
		for (int i : record) {
			if (i < 0){
				return false;
			}
		}

		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
