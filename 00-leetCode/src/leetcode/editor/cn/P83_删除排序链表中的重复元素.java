package leetcode.editor.cn;

/**
 * 删除排序链表中的重复元素
 * remove-duplicates-from-sorted-list
 * @author mqinrui
 * @date 2023-08-30 10:23:52
 */
class P83_RemoveDuplicatesFromSortedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
	 }
	private class ListNode {
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
    public ListNode deleteDuplicates(ListNode head) {
		//1遍历 暴力删除
//		return method1(head);
		
		//2.递归删除
//		return method2(head);

		//3.双指针 类似26题
		return method3(head);

		
		
    }

	/**
	 * 暴力遍历
	 * @param head
	 * @return
	 */
	private ListNode method1(ListNode head){
		if (head == null){
			return head;
		}

		ListNode current = head;
		while (current.next != null){
			if (current.val == current.next.val){
				current.next = current.next.next;
			}
			else {
				current = current.next;
			}
		}
		return head;
	}

	/**
	 * 递归
	 * @param head
	 * @return
	 */
	private ListNode method2(ListNode head){
		if (head == null || head.next == null) {
			return head;
		}
		head.next = method2(head.next);
		return head.next.val == head.val ? head.next : head;
	}

	/**
	 * 双指针
	 * @param head
	 * @return
	 */
	private ListNode method3(ListNode head){
		if (head == null){
			return null;
		}
		//快指针探路 遇到不一样的就让满指针前进 并复制给慢指针对应节点
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null){
			if (fast.val != slow.val){
				slow = slow.next;
				slow.val = fast.val;
			}
			fast = fast.next;
		}
		//断开后面重复元素
		slow.next = null;
		return head;
	}



}
//leetcode submit region end(Prohibit modification and deletion)


}
