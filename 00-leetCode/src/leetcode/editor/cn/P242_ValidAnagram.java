//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 751 👎 0


package leetcode.editor.cn;

/**
 * 有效的字母异位词
 * @author mqinrui
 * @date 2023-03-28 15:37:57
 */
public class P242_ValidAnagram{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P242_ValidAnagram().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
		//hash：数组其实就是一个简单哈希表
		// 统计s每个字母出现次数，一个字母出现一次就在hash数组对应位置+1
		//      然后遍历t，出现一个字母在hash数组对应位置-1
		//      如果s，t是有效字母异位词，那最后hash数组里面的value都是0
		int[] hash = new int[26];  //一共26个字母，ascii码连续
		for (int i = 0; i < s.length(); i++) {
			hash[s.charAt(i) - 'a']++;   // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
		}
		for (int i = 0; i < t.length(); i++) {
			hash[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] != 0){
				return false;
			}
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
