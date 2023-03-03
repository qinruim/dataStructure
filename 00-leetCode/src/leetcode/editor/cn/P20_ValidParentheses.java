//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3767 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 * @author mqinrui
 * @date 2023-03-03 16:32:55
 */
public class P20_ValidParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P20_ValidParentheses().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private HashMap<Character, Character> map = new HashMap<>();

	public Solution() {   	//用构造函数初始化map

		map.put('(',')');
		map.put('[',']');
		map.put('{','}');
	}

	public boolean isValid(String s) {
		/**
		 * 思路1：
		 * 遇见左括号 入栈
		 * 遇见右括号
		 *   如果栈为空，返回false
		 *   如果栈不为空，弹出栈顶元素匹配，匹配失败返回false
		 *   匹配成功继续遍历
		 * 最后判断栈内是否为空  为空则true  否则false
		 */

//		Stack<Character> stack = new Stack<>();
//		int length = s.length();
//		for (int i = 0; i < length; i++) {
//			char bracket = s.charAt(i);
//			//左括号入栈
//			if (bracket == '(' || bracket == '[' || bracket == '{'){
//				stack.push(bracket);
//			}
//			else {
//				//右括号且栈为空，false
//				if (stack.isEmpty()) {
//					return false;
//				}
//				//右括号且栈不为空
//				char left = stack.pop();
//				//弹出栈顶元素不匹配
//				if (left == '(' && bracket != ')') {
//					return false;
//				}if (left == '[' && bracket != ']') {
//					return false;
//				}if (left == '{' && bracket != '}') {
//					return false;
//				}
//			}
//		}
//		return stack.isEmpty();

		/**
		 * 思路2 用hashMap
		 *
		 */
				Stack<Character> stack = new Stack<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char bracket = s.charAt(i);
			//左括号入栈
			if (map.containsKey(bracket)){
				stack.push(bracket);
			}
			else {
				//右括号且栈为空，false
				if (stack.isEmpty()) {
					return false;
				}
				//右括号且栈不为空 弹出栈顶元素进行匹配
				if (map.get(stack.pop()) != bracket){
					return false;
				}
			}
		}
		return stack.isEmpty();


	}
}


//leetcode submit region end(Prohibit modification and deletion)

}
