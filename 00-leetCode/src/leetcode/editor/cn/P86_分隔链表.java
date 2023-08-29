package leetcode.editor.cn;

/**
 * 分隔链表
 * partition-list
 * @author mqinrui
 * @date 2023-08-29 11:00:03
 */
class P86_PartitionList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P86_PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
		//新建两个链表 一个放bix小的 另一个放大的
		ListNode dummy1 = new ListNode(-1);
		ListNode p1 = dummy1;

		ListNode dummy2 = new ListNode(-1);
		ListNode p2 = dummy2;

		ListNode p = head;

		while (p != null){
			if (p.val < x){
				p1.next = p;
				p1 = p1.next;
			}else {
				p2.next = p;
				p2 = p2.next;
			}
			//需要断开原链表  （如果原链表成环会无限循环）
//			p = p.next;
			ListNode temp = p.next;
			p.next = null;
			p = temp;
		}

		//拼接
		p1.next = dummy2.next;


		return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
