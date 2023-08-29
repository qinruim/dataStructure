package leetcode.editor.cn;

/**
 * 环形链表
 * linked-list-cycle
 * @author mqinrui
 * @date 2023-08-29 10:26:20
 */
class P141_LinkedListCycle{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P141_LinkedListCycle().new Solution();
	 }
	class ListNode {
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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                return true;
            }
        }

		return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
