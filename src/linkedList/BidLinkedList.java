package linkedList;

/**
 * 双向链表
 * @param <E>
 */
public class BidLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    /**
     * 节点（内部类） 包括存储的元素和下一个节点
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
     * 清空 第一个节点设为null即可
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

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        Node<E> node = first;
        Node<E> thisNode;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> preNode = node(index - 1);
            node = preNode.next;
            preNode.next = node.next;
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
