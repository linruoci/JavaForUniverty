public class HashBuck {

    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;//当前存放的数据元素的个数
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    public HashBuck() {
        this.array = new Node[8];
    }

    /**
     * 存放元素
     * @param key
     * @param val
     */
    public void put(int key,int val) {
        Node node = new Node(key, val);
        //确认当前的key是存放在 数组的 哪个下标的
        int index = key % array.length;

        /**
         * 遍历 index下标 的链表
         * 1. 查看是否有一样的key，有一样的替换val值
         * 2. 没有的话 进行头插法
         */
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        //说明 没有当前key  进行第2步  插入当前链表
        node.next = array[index];
        array[index] = node;
        usedSize++;
        //检查 当前哈希表中 是否超过了指定的负载因子
        if(loadFactor() >= DEFAULT_LOAD_FACTOR) {
            //扩容 & 同时进行重新的哈希
            resize();
        }
    }

    /**
     * 扩容了！
     * 面试问题：你知道哈希表的扩容需要注意什么吗？
     * 需要遍历数组的每个链表的每个节点 ，重新哈希到 新的哈希表当中。
     */
    private void resize() {
        Node[] temp = new Node[2* array.length];
        //遍历原来的数组
        for (int i = 0; i < array.length; i++) {
            //获取到 当前下标的链表的头节点
            Node cur = array[i];
            //遍历这个链表的每个节点
            while (cur != null) {
                Node curNext = cur.next;
                int index = cur.key % temp.length;//获取到当前key在 新的数组当中的位置
                cur.next = temp[index];
                temp[index] = cur;
                cur = curNext;
            }
        }
        array = temp;
    }

    private double loadFactor() {
        return usedSize*1.0/array.length;
    }

    /**
     * 通过key的值 获取val值
     * @param key
     */
    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

}