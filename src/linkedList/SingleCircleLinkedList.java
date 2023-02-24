package linkedList;

import java.security.cert.PKIXRevocationChecker;

/**
 * 双向链表
 * @param <E>
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    /**
     * 节点（内部类） 包括存储的元素和上一个、下一个节点
     * @param <E> 存储的元素
     */
    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
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
        if (index == 0){
            first = new Node<E>(element,first);
            //拿到最后一个节点
            Node<E> last = (size == 0) ? first : node(size - 1);
            last.next = first;
        }
        else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element,prev.next);
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
        //默认被删除的是first  其他情况后面会覆盖
        Node<E> node = first;
        if (index == 0){
            if (size == 1) {
                first = null;
            } else {
                Node<E> last = node(size - 1);
                first = first.next;
                last.next = first;
            }
        }
        else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
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
            //从左边开始找
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;


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
