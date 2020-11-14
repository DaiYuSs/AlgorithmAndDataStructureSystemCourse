package SelectionSort;

/**
 * @author ljj
 * @version 1.0
 * @date 2020/11/14
 */
public class Student implements Comparable<Student> {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    /**
     * 比较两个对象的成绩
     *
     * @param o 比较的对象
     * @return <0小于比较对象，=0相等，>0大于比较对象
     */
    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
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
        return name.equals(another.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
