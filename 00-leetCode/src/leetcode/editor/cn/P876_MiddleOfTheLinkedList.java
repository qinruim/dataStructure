package leetcode.editor.cn;

/**
 * 链表的中间结点
 * @author qr
 * @date 2023-03-01 00:23:20
 */
public class P876_MiddleOfTheLinkedList{
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
    public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
