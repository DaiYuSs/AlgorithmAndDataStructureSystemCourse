package Sort;

import utils.ArrayGenerator;

import static utils.ArrayUtil.swap;

/**
 * 选中排序类
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/14
 */
public class SelectionSort {
    private SelectionSort() {
    }

    /**
     * 升序
     *
     * @param arr 交换的数组
     * @param <E> 支持比较的泛型
     * @author ljj
     * @date 2020/11/14 16:04
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选中 arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        SortingHelper.sortTest(SelectionSort.class.getName(), ArrayGenerator.generateRandomArray(10000, 10000));
    }
}
