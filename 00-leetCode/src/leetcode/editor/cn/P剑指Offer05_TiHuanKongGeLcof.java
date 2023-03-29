//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//
// Related Topics 字符串 👍 451 👎 0


package leetcode.editor.cn;

/**
 * 替换空格
 * @author mqinrui
 * @date 2023-03-29 16:30:09
 */
public class P剑指Offer05_TiHuanKongGeLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P剑指Offer05_TiHuanKongGeLcof().new Solution();
		  String s = "we are friends!";
		 System.out.println(solution.replaceSpace(s));

	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
		//双指针法
		//扩充数组容量至有可能需要的最大容量，然后两个指针分别指向新旧数组的尾部，从后向前填充（从前向后会导致位置移动，增加时间复杂度）

		if (s == null || s.length() == 0){
			return s;
		}
		//统计空格个数
		//扩充空间 这个空间是在替换后刚好填满，即新旧指针重合
		int count = 0;
		int oldSize = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < oldSize; i++) {
			if (s.charAt(i) == ' '){
				count++;
				//出现一个空格，就添加两个空格，加上原来的相当于把空格部分扩充成原来的三倍
				sb.append("  ");
			}
		}

		//新字符串：原字符串拼接上添加的空格
		s += sb.toString();
		int newSize = oldSize + 2 * count;
		char[] chars = s.toCharArray();

		//定义两个指针,从后向前将空格替换为例“%20”
		int oldIndex = oldSize - 1;
		int newIndex = newSize - 1;
		while (oldIndex < newIndex){
			if (chars[oldIndex] == ' '){
				chars[newIndex--] = '0';
				chars[newIndex--] = '2';
				chars[newIndex--] = '%';
				oldIndex--;
			}
			else {
				chars[newIndex--] = chars[oldIndex--];
			}
		}
		return new String(chars);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
