package practice.techPractice.linkedList;

/**
 * 双向链表
 * @param <E>
 */
public class BidLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    /**
     * 节点（内部类） 包括存储的元素和上一个、下一个节点
     * @param <E> 存储的元素
     */
    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev,E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 清空
     */
    public void clear(){
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        //原来的节点
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 在指定位置插入节点
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheck(index);

        if (index == size) {
           //在最后面添加元素
            Node<E> oldLast = last;
            //新添加节点
            Node<E> last = new Node<>(oldLast, element,null);
            //之前链表为空，这是链表添加的第一个元素
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }

        } else {
            //插入位置原有节点即为要插入节点的next
            Node<E> next = node(index);
            //插入位置原有节点的上一个即为新插入节点的prev
            Node<E> prev = next.prev;
            //新节点
            Node<E> node = new Node<>(prev, element, next);
            //index=0
            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
            }
        }
        size++;
    }

    /**
     * 删除指定位置的元素 返回删除的元素
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        //要删除的元素
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev == null) { //index=0
           first = next;
        } else {
            prev.next = next;
        }
        if (next == null) { //index=size-1
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {   //内部设计 可以存储 null
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 传入索引 返回index位置的节点
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);

        if (index < (size >> 1)){
            //从左边开始找
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        else {
            //从右边开始找
            Node<E> node = last;
            for (int i = size-1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }

    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(size);
        Node<E> node =first;
        for (int i = 0; i < size; i++) {
            if (i != 0){
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        return string.toString();
    }
}
