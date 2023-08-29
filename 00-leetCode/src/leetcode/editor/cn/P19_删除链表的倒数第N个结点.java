package leetcode.editor.cn;

/**
 * 删除链表的倒数第 N 个结点
 * remove-nth-node-from-end-of-list
 * @author mqinrui
 * @date 2023-08-29 14:53:08
 */
class P19_RemoveNthNodeFromEndOfList{
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
		//虚拟头结点防止出现空指针
		//比如一共5个节点 要求删除倒数第五个 按照逻辑是找倒数第六个  会空指针
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode p1 = dummy;
		ListNode p2 = dummy;

		// 删除倒数第 n 个，要先找倒数第 n + 1 个节点
		//p1先走n+1步
		while (n + 1 > 0){
			p1 = p1.next;
			n--;
		}
//		for (int i = 0; i < n + 1; i++) {
//			p1 = p1.next;
//		}
		//然后两个一起走
		while (p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}

		//删除倒数第n个节点 即p2的后一个
		p2.next = p2.next.next;



		return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
