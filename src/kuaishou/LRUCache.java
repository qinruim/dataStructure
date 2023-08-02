package kuaishou;

import java.util.HashMap;

/**问题描述：
 * 设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 *
 * put(key, value) - 如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶：在 O(1) 时间复杂度内完成这两种操作
 *
 * 示例：
 * LRUCache cache = new LRUCache( 2 //缓存容量);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1); // 返回 1
 * cache.put(3, 3); // 该操作会使得关键字 2 作废
 * cache.get(2); // 返回 -1 (未找到)
 * cache.put(4, 4); // 该操作会使得关键字 1 作废
 * cache.get(1); // 返回 -1 (未找到)
 * cache.get(3); // 返回 3
 * cache.get(4); // 返回 4
 *
 *
 * 分析：
 * 实际是构建一个数据结构cache：有序（区分最近使用的数据和未使用的），且查找、插入、删除速度快
 * 因此，哈希表（查找快） + 双向链表（有序，插入删除快）
 *
 * 双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
 * 哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
 * 这样我们首先使用哈希表进行定位，找出缓存项在双向链表中的位置，
 * 随后将其移动到双向链表的头部，即可在 O(1)O(1) 的时间内完成 get 或者 put 操作
**/
public class LRUCache {
    //属性
    private int capacity;
    private DList cache;
    private HashMap<Integer,Node> map;

    //构造器
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new DList();
        this.map = new HashMap<>();
    }

    //类方法
    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        cache.makeRecently(node);
        return node.value;
    }
    public void put(int key,int value){
        Node newNode = new Node(key, value);
        if (map.containsKey(key)){
            Node oldNode = map.get(key);
            cache.remove(oldNode);
            cache.addFirst(newNode);
            map.put(key,newNode);
        }else {
            if (cache.size() == capacity){
                Node node = cache.removeLast();
                map.remove(node.key);
            }
            cache.addFirst(newNode);
            map.put(key,newNode);
        }
    }


}

//双链表节点类
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key,int value){}
}
//简易双向链表类
class DList{
    private int size;
    private Node head;
    private Node tail;
    //构造器初始化头尾两个节点，以后这两个节点一直是虚拟头尾
    public DList(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
    }
    //在头部添加节点（最新使用的节点）
    public void addFirst(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }
    //删除任意节点
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    //删除最后一个节点并返回（淘汰最久未使用元素）
    public Node removeLast(){
        if (this.head.next == this.tail){
            return null;
        }
        Node lastNode = this.tail.prev;
        this.remove(lastNode);
        return lastNode;
    }
    //将节点变成最新使用节点，删除再添加到头部即可
    public void makeRecently(Node node){
        this.remove(node);
        this.addFirst(node);
    }
    //获取双向链表长度
    public int size(){
        return this.size;
    }
}
