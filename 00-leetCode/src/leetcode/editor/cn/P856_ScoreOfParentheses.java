//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 473 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * 括号的分数
 * @author mqinrui
 * @date 2023-03-06 09:43:20
 */
public class P856_ScoreOfParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P856_ScoreOfParentheses().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {
		/**
		 * 思路1
		 *
		 */
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(0); //初始分数为0
		for (int i = 0; i < s.length(); i++) {
			//遍历字符串,为左括号，开始计算概括好内部字符串分数，压入初始分数0
			if (s.charAt(i) == '('){
				stack.push(0);
			}
			//为右括号，计算这个封闭括号（）内部字符串A分数,并入栈
			else {
				int v = stack.pop();
				//然后将 (A) 的分数加到栈顶元素上
				//如果 v=0，那么说明子平衡括号字符串 A 是空串，(A) 的分数为 1，否则 (A) 的分数为 2v
				int top = stack.pop() + Math.max(2*v,1);
				stack.push(top);
			}
		}
		//栈顶元素即分数
		return stack.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
