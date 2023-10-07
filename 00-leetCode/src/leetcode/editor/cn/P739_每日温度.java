package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 每日温度
 * daily-temperatures
 * @author mqinrui
 * @date 2023-09-27 16:24:07
 */
class P739_DailyTemperatures{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P739_DailyTemperatures().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] res = new int[n];
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			int tem = temperatures[i];
			while (!stack.isEmpty() && tem >= temperatures[stack.peek()]){
				stack.pop();
			}
			res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
			stack.push(i);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
