//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1169 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 移除链表元素
 * @author mqinrui
 * @date 2023-02-27 09:59:26
 */
public class P203_RemoveLinkedListElements{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P203_RemoveLinkedListElements().new Solution();

	 }

	 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	/**
	 * 方法一 找到prev 进行链表删除的操作 需要单独考虑头节点
	 * @param head
	 * @param val
	 * @return
	 */
//    public ListNode removeElements(ListNode head, int val) {
//		//删除头节点（若头节点值为要删除的）
//		while (head != null && head.val == val){
//			head = head.next;
//		}
//		if (head == null) {
//			return head;
//		}
//		//当前节点不必删除 设置为prev
//		ListNode prev = head;
//		//确保当前节点之后还有节点
//		while (prev.next != null){
//			if (prev.next.val == val){
//				prev.next = prev.next.next;
//			}
//			else {
//				prev = prev.next;
//			}
//		}
//		return head;
//
//	}

	/**
	 * 方法二 找到prev 进行链表删除的操作 添加虚拟头节点 不需要单独考虑头节点
	 * @param head
	 * @param val
	 * @return
	 */
//	public ListNode removeElements(ListNode head, int val) {
//		//虚拟头节点
//		ListNode virtualNode = new ListNode(val - 1);
//		virtualNode.next = head;
//		ListNode prev = virtualNode;
//		//链表删除操作
//		while (prev.next != null){
//			if (prev.next.val == val){
//				prev.next = prev.next.next;
//			}
//			else {
//				prev = prev.next;
//			}
//		}
//		return virtualNode.next;
////		return head;  //不能返回head 因为前面没有对head节点做任何处理  返回的是原来的头节点
//	}

	/**
	 * 方法三 递归
	 * 对于给定的链表，首先对除了头节点head以外的节点进行删除操作，然后判断
	 * head的节点值是否等于给定的val。如果head的节点值等于val，则head需要被删除，
	 * 因此删除操作后的头节点为head.next；
	 * 如果 head 的节点值不等于val，则head保留，因此删除操作后的头节点还是head。
	 * 上述过程是一个递归的过程。
	 * 递归的终止条件是head为空，此时直接返回head。
	 * 当head不为空时，递归地进行删除操作，然后判断head的节点值是否等于val 并决定是否要删除head
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
		if (head == null){
			return head;
		}

		head.next = removeElements(head.next,val);
		return head.val == val ? head.next : head;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
