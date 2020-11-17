package utils;

import utils.Interface.StackInterface;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/17
 */
public class ArrayStack<E> implements StackInterface<E> {

    /**
     * 存储数据的值
     */
    private Array<E> array;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 默认构造函数，开辟 10 个
     *
     * @author ljj
     * @date 2020/11/17
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 传入容量开辟
     *
     * @param capacity 容量
     * @author ljj
     * @date 2020/11/17
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 返回 Stack 长度
     *
     * @return int Stack长度
     * @author ljj
     * @date 2020/11/17
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 是否为空
     *
     * @return boolean true 为空，false 为有值
     * @author ljj
     * @date 2020/11/17
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取容量
     *
     * @return int 容量
     * @author ljj
     * @date 2020/11/17
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 插入新元素 e
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/17
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 弹出栈顶的元素
     *
     * @return E 元素
     * @author ljj
     * @date 2020/11/17
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶的元素
     *
     * @return E 元素
     * @author ljj
     * @date 2020/11/17
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
