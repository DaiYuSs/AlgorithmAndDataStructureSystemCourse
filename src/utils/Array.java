package utils;

import java.util.Arrays;

/**
 * 二次封装的数组类
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/15
 */
public class Array {

    /**
     * 存储数据的数组
     */
    private int[] data;

    /**
     * 数组元素的个数
     */
    private int size;

    /**
     * 默认构造容量为 10 的Array
     *
     * @author ljj
     * @date 2020/11/15
     */
    public Array() {
        this(10);
    }

    /**
     * 构造函数，传入容量构造Array
     *
     * @param capacity 数组容量
     * @author ljj
     * @date 2020/11/15
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 获取数组中元素个数
     *
     * @author ljj
     * @date 2020/11/15
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return int
     * @author ljj
     * @date 2020/11/15
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return boolean
     * @author ljj
     * @date 2020/11/15
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入到数组的末尾
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/15
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 插入到数组的第一个位置
     *
     * @param e 新元素
     * @author ljj
     * @date 2020/11/15
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 往 index 位置插入新元素 e
     *
     * @param index 指定位置
     * @param e     新元素
     */
    public void add(int index, int e) {
        if (size == data.length) {
            // 开辟新的数组
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + data.length +
                '}';
    }
}
