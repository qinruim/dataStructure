//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// 
//MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= index, val <= 1000 
// 请不要使用内置的 LinkedList 库。 
// get, addAtHead, addAtTail, addAtIndex 和 deleteAtIndex 的操作次数不超过 2000。 
// 
//
// Related Topics 设计 链表 👍 764 👎 0


package leetcode.editor.cn;

/**
 * 设计链表
 * @author mqinrui
 * @date 2023-03-08 20:58:19
 */
public class P707_DesignLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
         MyLinkedList myLinkedList = new P707_DesignLinkedList().new MyLinkedList();
     }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)



class MyLinkedList {
    /**
     * 链表节点
     */
    private class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }
    /**
     * 链表大小
     */
    private int size;
    /**
     * 虚拟头节点
     */
    private ListNode dummyHead;

    /**
     * 初始化链表
     */
    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode();
    }

    /**
     * 获取指定索引节点的val
     * @param index
     * @return
     */
    public int get(int index) {
        //索引无效
        if (index < 0 || index >= size){
            return  -1;
        }
        //用一个指针 指向需要找的节点，初始为真头节点
        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 在头节点之前添加一个值为val节点（新头节点）
     * 相当于在第0个元素前添加
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /**
     * 在尾部添加一个新节点
     * 相当于在（末尾+1）个元素前添加
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /**
     * 在链表中的index个节点之前添加值为val的节点。(新的第index个节点)
     * 如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size){
            return;
        }
        if (index < 0){
           index = 0;
        }
        //找到要添加位置的前一个节点 因为有虚拟头节点，不对头节点单独处理，那么寻找前置节点时只能从虚拟头节点开始
        ListNode cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //此时cur为 index - 1 节点(要插入位置的前一个节点)
        ListNode newIndex = new ListNode(val, cur.next);
        cur.next = newIndex;
        size++;
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1){
            return;
        }
        //头节点需要单独处理
        if (index == 0){
            dummyHead = dummyHead.next;
            size--;
            return;
        }
        //让 index-1 .next指向 index.next 尾节点的next为null  不需要单独处理
        ListNode cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //此时cur为 index - 1 节点(要插入位置的前一个节点)
        cur.next = cur.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
