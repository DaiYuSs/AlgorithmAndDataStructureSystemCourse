package utils;

/**
 * 数组相关的工具类
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/15
 */
public class ArrayUtil {

    /**
     * 交换数组中的两个位置的值
     *
     * @param arr 交换的数组
     * @param i   坐标i
     * @param j   坐标j
     * @author ljj
     * @date 2020/11/14
     */
    public static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
