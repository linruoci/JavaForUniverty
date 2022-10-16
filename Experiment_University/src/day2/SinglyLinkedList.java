package day2;

/**
 * @DATE: 2022/10/12 8:43
 * @PROJECT_NAME: Experiment_University
 * @author: 帅哥
 * @DESCRIPTION:
 */


public class SinglyLinkedList<E>{

    static class Node<E>{

        E value;
        Node<E> next;


        public Node(E value){

            this.value = value;

        }

    }
    //代表头节点
    private Node<E> head;
    private int size;



//    public SinglyLinkedList(E[] element)
//    public SinglyLinkedList(SinglyLinkedList list)



    public SinglyLinkedList(E[] element){

        if (element == null || element.length == 0){

            RuntimeException e = new RuntimeException("数组为空或者数组不存在");
            e.printStackTrace();

        }

        Node<E> tmp = head;



        for (int i = 0; i < element.length; i++){

            if (head == null){
                E e = element[i];
                Node<E> node = new Node<>(e);

                head = node;

                tmp = head;


            } else {

                E e = element[i];
                Node<E> node = new Node<>(e);

                tmp.next = node;
                tmp = tmp.next;

            }
            size++;



        }


    }

    public SinglyLinkedList(SinglyLinkedList<E> list){

        if (list == null){

            RuntimeException e = new RuntimeException("参数为null");
            e.printStackTrace();
            return;

        }

        Node<E> tmp = head;

        while (list != null){

            if (head == null){

                head = list.head;

            }


        }



    }





}
