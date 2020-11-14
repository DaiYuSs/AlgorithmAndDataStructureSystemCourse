package LinearSearch;

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

    public static Integer[] generateOrderArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
