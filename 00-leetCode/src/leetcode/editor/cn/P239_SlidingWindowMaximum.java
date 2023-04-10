//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2238 👎 0


package leetcode.editor.cn;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * @author mqinrui
 * @date 2023-04-10 19:49:19
 */
public class P239_SlidingWindowMaximum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P239_SlidingWindowMaximum().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		/**
		 * 暴力  两个指针遍历得到滑动窗口，滑动窗口内再遍历找出最大值
		 * O（n*k）
		 */

		/**
		 * 单调队列法 一个队列，push一个，pop一个，就是滑动窗口
		 * pop(value)：如果窗口移除的元素value等于单调队列的出口元素，那么队列弹出元素，否则不用任何操作
		 * push(value)：如果push的元素value大于入口元素的数值，那么就将队列入口的元素弹出，
		 * 				直到push元素的数值小于等于队列入口元素的数值为止
		 * 	这样每次获取最大值时，只需获取队列出口处的元素
		 */
		if (nums.length == 1){
			return nums;
		}
		int len = nums.length - k + 1;
		int[] result = new int[len];
		int index = 0;
		MyDeque myDeque = new MyDeque();
		//先将第一个窗口元素放入队列
		for (int i = 0; i < k; i++) {
			myDeque.add(nums[i]);
		}
		result[index++] = myDeque.peek();
		for (int i = k; i < nums.length; i++) {
			//滑动窗口移动
			myDeque.poll(nums[i - k]);
			myDeque.add(nums[i]);
			//获取当前滑动窗口最大值
			result[index++] = myDeque.peek();
		}
		return result;
	}
}

	/**
	 * 自定义单调队列
	 */
	class MyDeque{
		Deque<Integer> deque = new LinkedList<>();
		//弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
		//同时判断队列当前是否为空
		void poll(int val){
			if (!deque.isEmpty() && val == deque.peek()){
				deque.poll();
			}
		}

		//添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
		//保证队列元素单调递减
		//比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
		void add(int val){
			while (!deque.isEmpty() && val > deque.getLast()){
				deque.removeLast();
			}
			deque.add(val);
		}

		//队顶元素始终为最大值
		int peek(){
			return deque.peek();
		}

}
//leetcode submit region end(Prohibit modification and deletion)

}
