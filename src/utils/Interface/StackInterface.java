package utils.Interface;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/17
 */
public interface StackInterface<E> {

    /**
     * 返回 Stack 长度
     *
     * @return int Stack长度
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

    /**
     * 插入新元素 e
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/17
     */
    void push(E e);

    /**
     * 弹出栈顶的元素
     *
     * @return E 元素
     * @author ljj
     * @date 2020/11/17
     */
    E pop();

    /**
     * 查看栈顶的元素
     *
     * @return E 元素
     * @author ljj
     * @date 2020/11/17
     */
    E peek();
}
