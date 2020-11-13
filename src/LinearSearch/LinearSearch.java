package LinearSearch;

/**
 * 线性搜索
 * 泛型类
 *
 * @author ljj
 * @version 1.0
 * @date 2020/11/13
 */
public class LinearSearch<T> {

    private LinearSearch() {
    }

    /**
     * 线性搜索
     *
     * @param data   数组
     * @param target 搜索的值
     * @param <T>    泛型，需要调用equals
     * @return 返回target的下标，如果没找到就返回-1
     */
    static <T> int search(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {
            // equals比==更准确
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int res = LinearSearch.search(data, 16);
        System.out.println(res);
        res = LinearSearch.search(data, 77);
        System.out.println(res);

        Student[] students = {new Student("张三", 18), new Student("李四", 18), new Student("王五", 18)};
        Student lisi = new Student("李四", 18);
        res = LinearSearch.search(students, lisi);
        System.out.println(res);
    }
}
