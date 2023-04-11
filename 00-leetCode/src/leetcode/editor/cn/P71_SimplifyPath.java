package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 简化路径
 * @author mqinrui
 * @date 2023-04-11 09:42:06
 */
public class P71_SimplifyPath{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P71_SimplifyPath().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String simplifyPath(String path) {
		/**
		 * 给的path是有效的绝对路径
		 *将给定path按照/分割成一个字符串数组paths
		 * 因此，paths数组中只包含 空格,.,..,目录名（除前面三种情况都是目录名）
		 * 将目录名压入栈中，遇到..弹出一个表示回到上一层目录，遇到一个点和空格忽略即可，因为目录不需要切换
		 * 最后将栈中元素用/连接
		 */
		Deque<String> deque = new LinkedList<>();
		String[] paths = path.split("/");
		for (String s : paths) {
			//.. 弹出
			if (s.equals("..")){
				if (!deque.isEmpty()){
					deque.pollLast();
				}
			}
			//为目录名，入栈
			else if (s.length() > 0 && !s.equals(".")){
				deque.offerLast(s);
			}
		}
		//将栈中元素用/拼接
		StringBuilder result = new StringBuilder();
		if (deque.isEmpty()){
			result.append("/");
		}else {
			while (!deque.isEmpty()) {
				result.append("/");
				result.append(deque.pollFirst());
			}
		}
		return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
