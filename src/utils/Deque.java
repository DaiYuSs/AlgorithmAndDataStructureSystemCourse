package utils;

import utils.Interface.QueueInterface;

import java.util.Arrays;

/**
 * 双端队列
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/21
 */
public class Deque<E> implements QueueInterface<E> {

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
     * @date 2020/11/21
     */
    public Deque() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 传入容量开辟
     *
     * @param capacity 容量
     * @author ljj
     * @date 2020/11/21
     */
    public Deque(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 插入新元素到队首
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/21
     */
    @Override
    public void enqueue(E e) {
        addFront(e);
    }

    /**
     * 插入新元素到队首
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/21
     */
    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        front = (front + getCapacity() - 1) % getCapacity();
        data[front] = e;
        ++size;
    }

    /**
     * 插入新元素到队尾
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/21
     */
    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % getCapacity();
        ++size;
    }

    /**
     * 出队列，返回队列首元素
     *
     * @return E 队首元素
     * @author ljj
     * @date 2020/11/21
     */
    @Override
    public E dequeue() {
        return removeFront();
    }

    /**
     * 弹出队首元素
     *
     * @return E 队首元素
     * @author ljj
     * @date 2020/11/21
     */
    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % getCapacity();
        --size;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 弹出队尾元素
     *
     * @return E 队尾元素
     * @author ljj
     * @date 2020/11/21
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        tail = (tail + getCapacity() - 1) % getCapacity();
        E ret = data[tail];
        data[tail] = null;
        --size;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 查看队首元素
     *
     * @return E 队首元素
     * @author ljj
     * @date 2020/11/21
     */
    @Override
    public E getFront() {
        return get(front);
    }

    /**
     * 查看队尾元素
     *
     * @return E 队首元素
     * @author ljj
     * @date 2020/11/21
     */
    public E getLast() {
        int index = (tail + getCapacity() - 1) % getCapacity();
        return get(index);
    }

    /**
     * 私有方法
     * 获取指定索引的元素
     *
     * @param index 索引
     * @return E 元素
     * @author ljj
     * @date 2020/11/21
     */
    private E get(int index) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[index];
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

    /**
     * 获取容量
     *
     * @return int 容量
     * @author ljj
     * @date 2020/11/21
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回 Queue 长度
     *
     * @return int Queue长度
     * @author ljj
     * @date 2020/11/21
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
     * @date 2020/11/21
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Deque: size = %d, capacity = %d, front = %d, tail = %d, data[", getSize(), getCapacity(), front, tail));

        for (int i = 0; i < size; i++) {
            // 从 front 开始取数
            res.append(data[(front + i) % getCapacity()]);
            // +1 解决当容量满时 front == tail 判断出错
            if ((i + front + 1) % getCapacity() != tail) {
                res.append(", ");
            }
        }
        res.append("]");
        res.append(", origin: ").append(Arrays.toString(data));
        return res.toString();
    }
}
