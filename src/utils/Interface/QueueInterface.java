package utils.Interface;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/17
 */
public interface QueueInterface<E> {

    /**
     * 插入新元素
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/17
     */
    void enqueue(E e);

    /**
     * 出队列，返回队列首元素
     *
     * @return E 队首元素
     * @author ljj
     * @date 2020/11/17
     */
    E dequeue();

    /**
     * 查看队首元素
     *
     * @return E 队首元素
     * @author ljj
     * @date 2020/11/17
     */
    E getFront();

    /**
     * 返回 Queue 长度
     *
     * @return int Queue长度
     * @author ljj
     * @date 2020/11/17
     */
    int getSize();

    /**
     * 是否为空
     *
     * @return boolean true 为空，false 为有值
     * @author ljj
     * @date 2020/11/17
     */
    boolean isEmpty();
}
