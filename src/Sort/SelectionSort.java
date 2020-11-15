package Sort;

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

    /**
     * 交换数组中的两个位置的值
     *
     * @param arr 交换的数组
     * @param i   坐标i
     * @param j   坐标j
     * @author ljj
     * @date 2020/11/14 16:06
     */
    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5, 0};
        SelectionSort.sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

        Student[] students = {
                new Student("zhangsan", 90),
                new Student("lisi", 100),
                new Student("wangwu", 60)
        };
        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.print(student + " ");
        }
        System.out.println();
    }
}
