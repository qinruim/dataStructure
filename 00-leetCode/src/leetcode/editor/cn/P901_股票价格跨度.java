package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 股票价格跨度
 * online-stock-span
 * @author mqinrui
 * @date 2023-10-07 10:35:36
 */
class P901_OnlineStockSpan{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P901_OnlineStockSpan().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class StockSpanner {
    private Stack<int[]> stack; //存储索引和股票价格
    private int curDay;
    public StockSpanner() {
        stack = new Stack<>();
        curDay = -1;
        //初始化时往栈底添加一个 (−1,∞)
        // 这样栈一定不会为空，无需单独处理 pprice 大于等于之前所有输入的情况。
        //给的测试用例 第一个输入null 题目认为他比所有都大
        stack.push(new int[]{-1,Integer.MAX_VALUE});
    }
    
    public int next(int price) {
        //返回当日价格跨度,即找到他前面第一个比他大的数的索引
        curDay++;
        while (price >= stack.peek()[1]){
            stack.pop();
        }
        int res = curDay - stack.peek()[0];
        stack.push(new int[]{curDay,price});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)


}
