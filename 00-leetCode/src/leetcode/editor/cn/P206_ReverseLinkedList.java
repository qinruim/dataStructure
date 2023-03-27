//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 2965 👎 0


package leetcode.editor.cn;

/**
 * 反转链表
 *
 * @author mqinrui
 * @date 2023-02-21 17:07:32
 */
public class P206_ReverseLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P206_ReverseLinkedList().new Solution();
    }

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

//力扣代码
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
        /**
         * 非递归（迭代）
         * @param head
         * @return
         */
//    public ListNode reverseList(ListNode head) {
//        //递归 简洁写法
////        if (head == null || head.next == null){
////            return head;
////        }
////        //反转成功后 应该有 原来的尾节点变成头节点，原来的头节点（传入的节点）变成尾节点指向null
////        ListNode newHead = reverseList(head.next);
////        //已经得到除了原来的head以外的反转结果，还需要让原来的head.next指向原来的head,原来的head指向null
////        head.next.next = head;
////        head.next = null;
////        return newHead;
//
//
//        //非递归(双指针)
//        //初始化：  前一个接节点为null  当前节点为head
//        ListNode pre = null;
//        ListNode cur = head;
//        //先让当前节点的下一个翻转指向pre，然后pre和cur后移，继续翻转。直到最后一个节点
//        while (cur != null){
//            //后一个节点为 cur.next
//            ListNode next = cur.next;
//
//            //翻转
//                //当前节点的下一个翻转指向pre
//            cur.next = pre;
//                //pre和cur后移
//            pre = cur;
//            cur = next;
//
//        }
//        return pre;
//    }

        /**
         * 双指针的思路递归
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            //相当于双指针初始化
            //ListNode pre = null;
            //ListNode cur = head;
            return reverse(null, head);
        }

        private ListNode reverse(ListNode pre, ListNode cur) {
            if (cur == null){
                return pre;
            }
            ListNode next = cur.next;
            //翻转
            cur.next = pre;
            //递归
            //相当于双指针的pre，cur后移到cur，next位置
            //pre = cur;
            //cur = next;
            return reverse(cur,next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
