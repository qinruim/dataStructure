//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1771 👎 0


package leetcode.editor.cn;

/**
 * 两两交换链表中的节点
 * @author mqinrui
 * @date 2023-03-26 11:23:28
 */
public class P24_SwapNodesInPairs {
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P24_SwapNodesInPairs().new Solution();
	}

	// 11
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)

		/**
		 * Definition for singly-linked list.
		 * public class ListNode {
		 * int val;
		 * ListNode next;
		 * ListNode() {}
		 * ListNode(int val) { this.val = val; }
		 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 * }
		 */
		class Solution {
			public ListNode swapPairs(ListNode head) {
				//cur为即将交换的俩节点的前面那个节点
				ListNode dummyHead = new ListNode();
				dummyHead.next = head;
				ListNode cur = dummyHead;

				//开始遍历
				//终止条件：节点为偶数个，即cur.next为null；节点为奇数个，即cur.next.next为空；结束遍历
				//注意两个条件不能写反，否则可能导致NPE
				while (cur.next != null && cur.next.next != null){
					//记将要交换的俩节点A，B。 下一轮的为A1,B1
					//储存临时节点 A 和 A1
					ListNode temp = cur.next;
					ListNode temp1 = cur.next.next.next;

					//交换 三个步骤
					cur.next = cur.next.next; 		//步骤一，cur指向B
					cur.next.next = temp;			//步骤二，B指向A
					cur.next.next.next = temp1;		//步骤一，A指向A1

					//cur后移两位，准备下一轮
					cur = cur.next.next;

				}

				return dummyHead.next;
			}
		}
//leetcode submit region end(Prohibit modification and deletion)


}
