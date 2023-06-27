//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。 
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否仅用一个队列来实现栈。 
//
// Related Topics 栈 设计 队列 👍 688 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * @author mqinrui
 * @date 2023-04-10 17:02:09
 */
public class P225_ImplementStackUsingQueues{
	 public static void main(String[] args) {
	 	 //测试代码
         MyStack myStack = new P225_ImplementStackUsingQueues().new MyStack();
     }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    Queue<Integer> queue1; //和栈中元素保持一致
    Queue<Integer> queue2; //辅助队列,用来备份
    //初始化
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        //先放入辅助队列
        queue2.offer(x);
        //将1中元素全部放入2(最终目的是将2中元素顺序调整成栈的弹出顺序，再交给1)
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        //交换1和2，最终全部存入1
        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;
    }

    public int pop() {
        //queue1中元素与栈中元素保持一致，关注queue即可
        return queue1.poll(); //poll()方法返回并移除容器前面的元素
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

    /**
     * 用一个队列模拟栈的操作
     * 只需要将队列中前 size-1 个元素弹出再添加到队列中，即可将队列中元素书讯调整成栈的顺序
     */
//    class MyStack {
//        Queue<Integer> queue;
//
//        //初始化
//        public MyStack() {
//            queue = new LinkedList<>();
//        }
//
//        public void push(int x) {
//            queue.offer(x);
//            int size = queue.size();
//            size--;
//            while (size-- > 0) {
//                queue.offer(queue.poll());
//            }
//        }
//
//        public int pop() {
//            return queue.poll();
//        }
//
//        public int top() {
//            return queue.peek();
//        }
//
//        public boolean empty() {
//            return queue.isEmpty();
//        }
//    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
