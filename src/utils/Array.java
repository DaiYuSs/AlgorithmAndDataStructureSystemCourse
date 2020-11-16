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
            data = Arrays.copyOf(data, data.length * 2);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    /**
     * 获取 index 索引位置的元素
     *
     * @param index 索引
     * @return 索引对应值
     * @author ljj
     * @date 2020/11/16
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index <= size.");
        }
        return data[index];
    }

    /**
     * 修改 index 索引位置的元素为 e
     *
     * @param index 索引
     * @param e     修改值
     * @author ljj
     * @date 2020/11/16
     */
    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index <= size.");
        }
        data[index] = e;
    }

    /**
     * 是否包含 e 元素
     *
     * @param e 值
     * @return true包含，false不包含
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素 e 的所在位置
     *
     * @param e 值
     * @return int e 的索引，不存在 e 则返回-1
     * @author ljj
     * @date 2020/11/16
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除 index 位置的元素，返回被删除的元素
     *
     * @param index 索引
     * @return int
     * @author ljj
     * @date 2020/11/16
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index <= size.");
        }
        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = i;
        }
        size--;
        return ret;
    }

    /**
     * 删除第一个元素，返回被删除的元素
     *
     * @return int
     * @author ljj
     * @date 2020/11/16
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素，返回被删除的元素
     *
     * @return int
     * @author ljj
     * @date 2020/11/16
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除第一个元素 e
     *
     * @param e 元素 e
     * @author ljj
     * @date 2020/11/16
     */
    public void removeElement(int e) {
        int index = find(e);
        if (index == -1) {
            remove(index);
        }
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
