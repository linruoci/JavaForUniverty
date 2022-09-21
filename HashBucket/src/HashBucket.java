public class HashBucket {
    private static class Node {
        private int key;
        private int value;
        Node next;
 
 
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
 
 
    private Node[]  array;
    private int size;   // 当前的数据个数
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 8;//默认桶的大小

    public HashBucket() {
        array = new Node[DEFAULT_SIZE];
    }




    public void put(int key, int value) {
        // write code here

        Node node = new Node(key, value);

        int index = key % array.length;


        //判断插入进来的元素的key是否相同， 如果相同则覆盖；

        Node cur = array[index];

        while (cur != null){

            if (cur.key == key){

                cur.value = value;
                return;

            }

            cur = cur.next;

        }





        //此时证明是一个全新的key， 我们用头插法的形式将其插入数组

        node.next = array[index];
        array[index] = node;
        size++;


        //插入过后， 需要判断此时是否超过负载因子， 如果超过负载因子的话需要重新哈希。


        if (loadFactor() >= LOAD_FACTOR){

            resize();

        }







    }
 
 
    private void resize() {

        Node[] tmp = new Node[2 * array.length];



        for (int i = 0; i < array.length; i++){

            Node cur = array[i];

            while (cur != null){


                Node curNext = cur.next;

                int index = cur.key % tmp.length;

                cur.next = tmp[index];

                tmp[index] = cur;

                cur = curNext;




            }

        }

        array = tmp;


    }
 
 
    private double loadFactor() {
        return size * 1.0 / array.length;
    }
 
 

 
    public int get(int key) {
         // write code here

        int index = key % array.length;

        Node cur = array[index];


        while (cur != null){

            if (cur.key == key){

                return cur.value;


            }
            cur = cur.next;



        }
        return -1;




    }
}