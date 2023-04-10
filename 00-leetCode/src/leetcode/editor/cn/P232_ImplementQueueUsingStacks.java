//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）： 
//
// 实现 MyQueue 类： 
//
// 
// void push(int x) 将元素 x 推到队列的末尾 
// int pop() 从队列的开头移除并返回元素 
// int peek() 返回队列开头的元素 
// boolean empty() 如果队列为空，返回 true ；否则，返回 false 
// 
//
// 说明： 
//
// 
// 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法
//的。 
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 1, 1, false]
//
//解释：
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
// 
//
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用 100 次 push、pop、peek 和 empty 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作） 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。 
// 
//
// Related Topics 栈 设计 队列 👍 879 👎 0


package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Stack;

/**
 * 用栈实现队列
 * @author mqinrui
 * @date 2023-04-06 16:17:34
 */
public class P232_ImplementQueueUsingStacks{
	 public static void main(String[] args) {
	 	 //测试代码
         MyQueue myQueue = new P232_ImplementQueueUsingStacks().new MyQueue();
     }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    /**
     * 用两个栈，一个输入栈，一个输出栈
     * 在push数据的时候，只要数据放进输入栈就好，
     * 但在pop的时候，操作就复杂一些，输出栈如果为空，就把进栈数据全部导入进来（注意是全部导入），
     * 再从出栈弹出数据，如果输出栈不为空，则直接从出栈弹出数据就可以了。
     */
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<>(); //负责进栈
        stackOut = new Stack<>(); //负责出栈
    }

    /**
     * 入队（将元素x压入栈中 ）
     * @param x
     */
    public void push(int x) {
        stackIn.push(x);
    }
    
    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }
    
    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

    //pop和peek的重复代码
    private void dumpStackIn() {
        //输出栈如果为空，就把进栈数据全部导入进来（
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
