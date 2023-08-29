package leetcode.editor.cn;

/**
 * 环形链表 II
 * linked-list-cycle-ii
 * @author mqinrui
 * @date 2023-08-29 15:39:50
 */
class P142_LinkedListCycleIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P142_LinkedListCycleIi().new Solution();
	 }


	private class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                slow = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
		return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
