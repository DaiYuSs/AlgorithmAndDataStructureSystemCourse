package utils;

import utils.Interface.QueueInterface;

import java.util.Arrays;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/18
 */
public class LoopQueue<E> implements QueueInterface<E> {
    /**
     * 存储数据的数组
     */
    private E[] data;

    /**
     * 队列首索引和队列尾索引
     */
    private int front, tail;

    /**
     * 元素个数
     */
    private int size;

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
    public LoopQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 传入容量开辟
     *
     * @param capacity 容量
     * @author ljj
     * @date 2020/11/17
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 获取容量
     *
     * @return int 容量
     * @author ljj
     * @date 2020/11/18
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回 Queue 长度
     *
     * @return int Queue长度
     * @author ljj
     * @date 2020/11/18
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return boolean true 为空，false 为有值
     * @author ljj
     * @date 2020/11/18
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入新元素
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/18
     */
    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队列，返回队列首元素
     *
     * @return E front 元素
     * @author ljj
     * @date 2020/11/18
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 查看队首元素
     *
     * @return E front 元素
     * @author ljj
     * @date 2020/11/18
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    /**
     * 对数组重新分配容量
     *
     * @param newCapacity 新容量
     * @author ljj
     * @date 2020/11/18
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        // 暂存从 front 开始的长度
        tail = getCapacity() - front;
        // 复制 front 右半边所有值
        System.arraycopy(data, front, newData, 0, Math.min(size, tail));
        // 复制从0开始所有值
        System.arraycopy(data, 0, newData, Math.min(size, tail), Math.max(0, size - tail));
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d,front [", getSize(), getCapacity()));

        for (int i = 0; i < size; i++) {
            // 从 front 开始取数
            res.append(data[(front + i) % data.length]);
            // +1 解决当容量满时 front == tail 判断出错
            if ((i + front + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        res.append(", origin: ").append(Arrays.toString(data));
        return res.toString();
    }
}
