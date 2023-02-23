//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// Related Topics 哈希表 链表 双指针 👍 1745 👎 0


package leetcode.editor.cn;

/**
 * 环形链表
 * @author mqinrui
 * @date 2023-02-22 12:09:55
 */
public class P141_LinkedListCycle{
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
	 
//力扣代码
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
		/**
		 * 快慢指针   二者相遇有环
		 */
//		ListNode fast = head;
//		ListNode slow = head;
//		//空链表、单节点链表一定没有环
//		if (head == null || head.next == null) {
//			return false;
//		}
//		//相对于slow来说，fast是一个节点一个节点的靠近slow的，所以fast一定可以和slow重合。
//		while (fast != null && fast.next != null){
//			fast = fast.next.next;  //快指针一次走两步
//			slow = slow.next;  //快指针一次走一步
//			if (fast == slow){  // 快慢指针相遇，表明有环
//				return true;
//			}
//		}
//		return false;  // 正常走到链表末尾，表明没有环
//    }

		/**
		 * 每遍历一个Node，就将next指向自己（做标记）
		 * 一直遍历下去，如果发现Node的next等于Node本身，
		 * 就说明曾经来过，也就证明存在循环列表
		 */
		while(head !=null && head.next !=null){
			ListNode next = head.next;  //临时变量
			if (next == head){  //head是当前节点
				return true;
			}
			//作标记:将next指向自己
			head.next = head;
			//遍历
			head = next;
		}
		return false;
	}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
