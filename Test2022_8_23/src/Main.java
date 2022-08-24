import java.util.PriorityQueue;

/**
 * @PROJECT_NAME: Test2022_8_23
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/23 16:31
 */
public class Main {


    public static void main2(String[] args) {

        PriorityQueue<Integer> tmp = new PriorityQueue<>(1);

        tmp.offer(10);
        tmp.offer(20);
        System.out.println(tmp);
    }



    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        TestHeap testHeap = new TestHeap();

        testHeap.createHeap(array);
        testHeap.sortHeap();
        System.out.println("afafafaf");
    }

}
