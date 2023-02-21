package linkedList;

/**
 * 抽取公共代码（因为接口不能写公共代码）
 * 定义成抽象类 可以不实现接口中的全部方法
 * 抽象类实现接口  相当于让子类也实现了接口
 * protrcted 子类可以访问
 * @param <E>
 */
public abstract class AbstractList<E> implements List<E>{
    /**
     * 元素的数量
     */
    protected int size;
    /**
     * 元素的数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
}

}
