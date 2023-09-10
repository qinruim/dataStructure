package leetcode.editor.cn;

import java.util.*;

/**
 * 相交链表
 * intersection-of-two-linked-lists
 * @author mqinrui
 * @date 2023-08-29 16:02:31
 */
class P160_IntersectionOfTwoLinkedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P160_IntersectionOfTwoLinkedLists().new Solution();
	 }

	public class ListNode {
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
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//方法1. 先遍历一个 将节点依次加入set 再遍历另一个 有相同节点即所求
//		return method1(headA,headB);

		//方法2：双指针
		return method2(headA,headB);

		//方法3:双指针 思路类似方法2
//		return method3(headA,headB);



    }

	private ListNode method3(ListNode headA, ListNode headB) {
		//既然问题在两个链表相交前长度不等  那记录一下两个链表的长度 长的那个先走几步 即可
		int lenA = 0,lenB = 0;
		ListNode pa = headA;
		ListNode pb = headB;

		while (pa != null){
			pa = pa.next;
			lenA++;
		}
		while (pb != null){
			pb = pb.next;
			lenB++;
		}

		pa = headA;
		pb = headB;

		if (lenA > lenB){
			for (int i = 0; i < lenA - lenB; i++) {
				pa = pa.next;
			}
		}
		if (lenA < lenB){
			for (int i = 0; i < lenB - lenA; i++) {
				pb = pb.next;
			}
		}

		//齐头并进
		while (pa != pb){
			pa = pa.next;
			pb = pb.next;
		}
		return pa;
	}

	private ListNode method2(ListNode headA, ListNode headB) {
		//双指针就是想办法让两个指针在相交处相遇 这要求相交前两个链表的长度一样
		//那么分别拼接一下即可
		ListNode pa = headB;
		ListNode pb = headA;
		//解释： 当没有相交 在一次拼接后  二者会同时指向null  满足pa==pb  结束 并返回null
		//因此没有相交也可返回正确结果 且 不会无限拼接下去
		while (pa != pb){
			if (pa == null){
				pa = headA;
			}else {
				pa = pa.next;
			}
			if (pb == null){
				pb = headB;
			}else {
				pb = pb.next;
			}
		}

		//这样 二者永远不会指向null  会无限循环
//		while (pa != pb){
//			if (pa.next == null){
//				pa.next = headA;
//			}
//			pa = pa.next;
//
//			if (pb.next == null){
//				pb.next = headB;
//			}
//			pb = pb.next;
//		}

		return pa;
	}




	private ListNode method1(ListNode headA, ListNode headB) {
		//hashmap和set都行
//		Map<ListNode,Integer> map = new HashMap<>();
		Set<ListNode> set = new HashSet<>();
		ListNode pa = headA;
		ListNode pb = headB;
		while (pa != null){
//			map.put(pa,1);
			set.add(pa);
			pa = pa.next;
		}
		while (pb != null){
//			if (map.containsKey(pb)){
			if (set.contains(pb)){
				return pb;
			}else {
				pb = pb.next;
			}
		}
		return null;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
