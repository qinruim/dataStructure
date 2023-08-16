package practice.techPractice.dynamicArray;

import java.util.Arrays;

/**动态数组接口设计
 * int size(); // 元素的数量
 * ◼ boolean isEmpty(); // 是否为空
 * ◼ boolean contains(E element); // 是否包含某个元素
 * ◼ void add(E element); // 添加元素到最后面
 * ◼ E get(int index); // 返回index位置对应的元素
 * ◼ E set(int index, E element); // 设置index位置的元素
 * ◼ void add(int index, E element); // 往index位置添加元素
 * ◼ E remove(int index); // 删除index位置对应的元素
 * ◼ int indexOf(E element); // 查看元素的位置
 * ◼ void clear(); // 清除所有元素
 *
 * 提供给外部调用  都是public
 */
public class ArrayList<E> {
    /**
     * 元素的数量
     */
    private int size;
    /**
     * 存放元素
     */
    private E[] elements;
    private static final int DEFAULE_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 构造函数 传入数组容量
     * @param capaticy
     */
    public ArrayList(int capaticy){
        capaticy = (capaticy < 10) ? DEFAULE_CAPACITY : capaticy;
        E[] elements = (E[]) new Object[capaticy];
    }

    /**
     * 无参构造函数  默认存放10个元素
     * this 调用由参构造函数
     */
    public ArrayList(){
        this(DEFAULE_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;     //泛型  释放存储对象的内存空间
        }
        size = 0;
    }

    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
//        return (size > 0) ? false : true;
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加一个元素到最后面
     * @param element
     */
    public void add(E element){
//        elements[size++] = element;
//        size ++;
        this.add(size,element);
    }

    /**
     * 添加元素到index位置  O()
     * @param element
     */
    public void add(int index,E element){
        if (index < 0 || index >= size + 1){
            throw new IndexOutOfBoundsException("Index = " + index + ",Size = " + size);
        }
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 保证数组容量   扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        //当前容量是elements数组长度
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity){
            return;
        }
        //新容量为旧容量1.5倍              二进制 右移一位相当于除以2
        int newCapacity = oldCapacity + oldCapacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 返回index位置对应元素  O(1)
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index = " + index + ",Size = " + size);
        }
        return elements[index];
    }

    /**
     * 设置index位置对应元素  O(1)
     * @param index
     * @return 原来的元素
     */
    public E set(int index,E element){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index = " + index + ",Size = " + size);
        }
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 删除index位置对应元素
     * @param index
     * @return 删除位置的索引
     */
    public E remove(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index = " + index + ",Size = " + size);
        }
        trim(size);
        E old = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size--] = null;
        return old;
    }

    /**
     * 缩容操作
     * @param size
     */
    private void trim(int size) {
        int oldCapacity = elements.length;
        //新容量为旧容量一半    二进制 右移一位相当于除以2
        int newCapacity = oldCapacity >> 1;
        if (size >= oldCapacity >> 1 || oldCapacity <= DEFAULE_CAPACITY){
            return;
        }
        //程序到这里说明剩余空间还足够大
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;


    }

    /**
     * 查看元素位置
     * @param element
     * @return
     */
    public int indexOf(E element){
        if (element == null) {   //内部设计 可以存储 null
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0){
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
