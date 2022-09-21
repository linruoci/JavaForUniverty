import java.util.Arrays;

/**
 * @PROJECT_NAME: MyLinkedList
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/3 22:39
 */
public class MyLinkedList {


    static class Node{

        public int val;
        public Node next;

        public Node(int val) {

            this.val = val;

        }
    }
    Node head = null;


    public void addFisrt(int val){

        Node node = new Node(val);
        //第一次插入.
        if (head == null){

            head = node;
            return;

        }

        //
        node.next = head;
        head = node;




    }


    public static void main(String[] args) {

        Arrays.sort();

    }



}
