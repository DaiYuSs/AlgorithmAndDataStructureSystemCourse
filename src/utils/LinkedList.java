package utils;

/**
 * 链表
 *
 * @author ljj
 * @date 2020/12/23
 */
public class LinkedList<E> {

    /**
     * 节点内部类
     *
     * @author ljj
     * @date 2020/12/23
     */
    private class Node {
        /**
         * 元素
         */
        public E e;

        /**
         * 下一个节点的指针
         */
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 链表的虚拟头节点
     */
    private Node dummyHead;
    /**
     * 链表的长度
     */
    private int size;

    public LinkedList() {
        this(null);
        size = 0;
    }

    public LinkedList(E e) {
        dummyHead = new Node(e, null);
        size = 1;
    }


    /**
     * 往指定索引位置添加一个新的元素
     * ps.链表中不是一个常用功能，练习用 :)
     *
     * @param index 索引
     * @param e     新元素
     * @return boolean true新增成功，false新增失败
     * @author ljj
     * @date 2020/12/23
     */
    public boolean add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        while (index-- != 0) {
            prev = prev.next;
        }
        // Node node = new Node(e);
        // node.next = prev.next;
        // prev.next = node;
        prev.next = new Node(e, prev.next);

        size++;
        return true;
    }

    /**
     * 往链表头部添加新的元素
     *
     * @param e 新元素
     * @return boolean true新增成功，false新增失败
     * @author ljj
     * @date 2020/12/23
     */
    public boolean addFirst(E e) {
        return add(0, e);
    }

    /**
     * 往链表尾部添加新的元素
     *
     * @param e 新元素
     * @return boolean true新增成功，false新增失败
     * @author ljj
     * @date 2020/12/23
     */
    public boolean addLast(E e) {
        return add(size, e);
    }

    /**
     * 获取链表中的元素个数
     *
     * @return int 链表长度
     * @author ljj
     * @date 2020/12/23
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return true为空，false不为空
     * @author ljj
     * @date 2020/12/23
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
