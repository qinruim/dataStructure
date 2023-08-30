package leetcode.editor.cn;

/**
 * 链表的中间结点
 * middle-of-the-linked-list
 * @author mqinrui
 * @date 2023-08-29 15:25:41
 */
class P876_MiddleOfTheLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P876_MiddleOfTheLinkedList().new Solution();
	 }
	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//力扣代码提交区
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
    public ListNode middleNode(ListNode head) {
//		ListNode dummy = new ListNode(-1);
//		dummy.next = head;

		//如果偶数个节点  要返回前一个中间结点 初始指向dummy
		//				   后一个         则     head
		ListNode fast = head;
		ListNode slow = head;

		//最后可能指向null 或者最后一个节点 都要停止
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
