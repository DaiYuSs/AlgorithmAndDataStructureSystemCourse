package Sort;

import utils.ArrayGenerator;

/**
 * 插入排序类
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/15
 */
public class InsertionSort {
    private InsertionSort() {
    }

    /**
     * 升序
     *
     * @param arr 数组
     * @author ljj
     * @date 2020/11/15
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j >= 1; j--) {
                if (t.compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = t;
        }
    }

    /**
     * 降序
     * [0,i)未排序，[i,n]已排序，从后往前遍历
     *
     * @param arr 数组
     * @author ljj
     * @date 2020/11/15
     */
    public static <E extends Comparable<E>> void descendingSort(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j < arr.length - 1; j++) {
                if (t.compareTo(arr[j + 1]) < 0) {
                    arr[j] = arr[j + 1];
                } else {
                    break;
                }
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(5, 5);
        SortingHelper.sortTest(InsertionSort.class.getName(), arr);
        InsertionSort.descendingSort(arr);
    }
}
