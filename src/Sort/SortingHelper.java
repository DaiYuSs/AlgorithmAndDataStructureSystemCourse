package Sort;

/**
 * 排序助手
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/14
 */
public class SortingHelper {
    private SortingHelper() {
    }

    /**
     * 判断数组是否升序
     *
     * @param arr 数组
     * @param <E> 支持 Comparable 接口
     * @return boolean
     * @author ljj
     * @date 2020/11/14
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 指定一个排序类对数组排序(升序)
     *
     * @param sortName 使用的排序对象
     * @param arr      数组
     * @param <E>      支持 Comparable 接口
     * @author ljj
     * @date 2020/11/15
     */
    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();

        if (SelectionSort.class.getName().equals(sortName)) {
            SelectionSort.sort(arr);
        }

        long endTime = System.nanoTime();

        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(String.format("%s , n = %d : %f s", sortName, arr.length, (endTime - startTime) / 1000000000.0));
    }
}
