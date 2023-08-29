package leetcode.editor.cn;

/**
 * 合并两个有序链表
 * merge-two-sorted-lists
 * @author mqinrui
 * @date 2023-08-29 10:29:41
 */
class P21_MergeTwoSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P21_MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //用一个新的链表来装
        ListNode dummy = new ListNode(-1); //虚拟头结点
        ListNode p = dummy; //p是新链表的指针

		//两个指针分别指向两个头结点
		ListNode p1 = list1;
		ListNode p2 = list2;

        //将小的放在p里面
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        //当有一个链表到头 将另一个拼上去即可
        while (p1 != null){
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while (p2 != null){
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }


        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
