package day2;

/**
 * @DATE: 2022/10/12 8:20
 * @PROJECT_NAME: Experiment_University
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class Test {


    public static void main(String[] args) {


        Integer[] array = {1, 2, 3, 8, 6, 9, 10};

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(array);

        System.out.println("fafafa");



    }



    public static void main1(String[] args) {

        MyArrayList arrayList = new MyArrayList();

        arrayList.add(1);

        arrayList.add(3);

        arrayList.add(2);


        arrayList.add(9);


        arrayList.add(7);

        arrayList.remove(11);


        arrayList.display();

    }


}
