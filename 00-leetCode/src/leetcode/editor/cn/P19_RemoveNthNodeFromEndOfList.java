//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2472 👎 0


package leetcode.editor.cn;

/**
 * 删除链表的倒数第 N 个结点
 * @author mqinrui
 * @date 2023-03-26 11:57:14
 */
public class P19_RemoveNthNodeFromEndOfList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1,head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        //将fast移到 n+1 位置（slow与fast相差n）
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //然后slow，fast一起移动，直到fast指向null
        //此时slow刚好指向要删除的前一个元素（二者相差n）
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //删除slow后一个元素
        slow.next = slow.next.next;


		return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
