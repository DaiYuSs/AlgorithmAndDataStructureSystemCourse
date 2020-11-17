package utils;

import utils.Interface.QueueInterface;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/17
 */
public class ArrayQueue<E> implements QueueInterface<E> {

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
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 传入容量开辟
     *
     * @param capacity 容量
     * @author ljj
     * @date 2020/11/17
     */
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 插入新元素
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/17
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队列，返回队列首元素
     *
     * @return E 队首元素
     * @author ljj
     * @date 2020/11/17
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 查看队首元素
     *
     * @return E 队首元素
     * @author ljj
     * @date 2020/11/17
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * 返回 Queue 长度
     *
     * @return int Queue长度
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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
