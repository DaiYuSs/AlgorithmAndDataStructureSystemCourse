package LinearSearch;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/13
 */
public class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 判断两个对象的 name 和 age 是否相等
     *
     * @param obj 判断的对象
     * @return true是同样的对象，false是不同的对象
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        Student another = (Student) obj;
        return name.equals(another.name) && age.equals(another.age);
    }
}
