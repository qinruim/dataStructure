package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 合并 K 个升序链表
 * merge-k-sorted-lists
 * @author mqinrui
 * @date 2023-08-29 11:19:38
 */
class P23_MergeKSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P23_MergeKSortedLists().new Solution();
		  ListNode[] lists = new ListNode[3];
		  ListNode l1 = new ListNode(1);
		  l1.next = new ListNode(4);
		  l1.next.next = new ListNode(5);
		  ListNode l2 = new ListNode(1);
		  l2.next = new ListNode(3);
		  l2.next.next = new ListNode(4);
		  ListNode l3 = new ListNode(2);
		  l3.next = new ListNode(6);

		  lists[0] = l1;
		  lists[1] = l2;
		  lists[2] = l3;

		  ListNode res = solution.mergeKLists(lists);
		  while (res != null){
			  System.out.print(res.val + "\t");
			  res = res.next;
		  }

	 }

	public static class ListNode {
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
    public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0){ // 防止[]
			return null;
		}
		//跟合并两个的区别：k个节点找出最小值  首先想到用TreeMap 但是超时了
		//用 优先级队列-最小堆  PriorityQueue
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;

//		TreeMap<Integer,ListNode> map = new TreeMap<>();
		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		//各个头结点加入map
		for (ListNode head : lists) {
			if (head != null) {  // 否则[[]]会空指针
//				map.put(head.val,head);
				pq.add(head);
			}
		}

//		while (!map.isEmpty()){
//			//获取最小节点 加入结果链表
//			ListNode node = map.get(map.firstKey());
//			p.next = node;
//			//将取出节点的后一个加入map
//			if (node.next != null){
//				map.put(node.next.val,node.next);
//			}
//			p = p.next;
//		}

		while (!pq.isEmpty()){
			//获取最小节点 加入结果链表
			ListNode node = pq.poll();
			p.next = node;
			//将取出节点的后一个加入map
			if (node.next != null){
				pq.add(node.next);
			}
			p = p.next;
		}

		return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
