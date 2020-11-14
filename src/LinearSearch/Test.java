package LinearSearch;

import utils.ArrayGenerator;

/**
 * 测试类
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/14
 */
public class Test {
    public static void main(String[] args) {
        int n = 1000000;
        Integer[] data = ArrayGenerator.generateOrderArray(n);

        long startTime = System.nanoTime();
        LinearSearch.search(data, 100000);
        long endTime = System.nanoTime();

        System.out.println("n = " + n + ",执行时间:" + (endTime - startTime) / 1000000000.0);
    }
}
