package utils;

import java.util.Random;

/**
 * 数组生成器
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/14
 */
public class ArrayGenerator {
    private ArrayGenerator() {
    }

    /**
     * 生成一个长度为 n 的有序数组
     *
     * @param n 数组长度
     * @return 生成的数组
     */
    public static Integer[] generateOrderArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个长度为 n 随机数组，范围是[0,bound)
     *
     * @param n     数组长度
     * @param bound 随机数的最大值-1[0,bound)
     * @return 生成的数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}
