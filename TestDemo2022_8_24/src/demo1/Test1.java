package demo1;

import java.util.ArrayList;

/**
 * @PROJECT_NAME: TestDemo2022_8_24
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/30 21:04
 */
public class Test1 {


    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList();
        arr.add(3);
        arr.add(5);
        arr.add(8);
        arr.display();

        System.out.println("----------------------------");

        arr.add(1, 99);
        arr.display();

        System.out.println("------------------------");

//
//        System.out.println(arr.contains(3));
//        System.out.println(arr.contains(9999));
//        System.out.println(arr.contains(8));
//        System.out.println(arr.contains(5));
//
//        System.out.println(arr.indexOf(-1));
//
//        System.out.println(arr.get(-1));


        arr.remove(5);

        arr.display();

       // System.out.println(arr.size());
//
//        arr.clear();
//        System.out.println("hhhhhhhhhhh");
//        arr.display();


    }


}
