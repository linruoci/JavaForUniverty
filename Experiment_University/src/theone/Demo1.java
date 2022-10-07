package theone;

import java.util.Arrays;

/**
 * @PROJECT_NAME: Experiment_University
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/9/28 8:06
 */


class Student implements Comparable<Student>{

    private int age;
    private String name;


    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    public Student(int age) {
        this.age = age;
    }

}






public class Demo1 {


    public static void main(String[] args) {

        Student a1 = new Student(1);
        Student a2 = new Student(2);
        Student a3 = new Student(3);
        Student a4 = new Student(4);


        Student[] array= {a1, a2, a3, a4};

        boolean flag = isSort(array);

        System.out.println(flag);

    }

    public static boolean isSort(int[] table){

        if (table == null){
            return false;
        }

        for (int i = 0; i < table.length - 1; i++){

            if  (table[i] > table[i + 1]){
                return false;
            }

        }
        return true;

    }

    public static boolean isSort(Comparable[] table){

        if (table == null) {
            return false;
        }

        for (int i = 0; i < table.length - 1; i++){

            if (((Student)table[i]).compareTo((Student) table[i + 1]) > 0){

                return false;


            }

        }

        return true;


    }



    public static void main1(String[] args) {
//        int[] array = {1, 2, 3, 4, 6, 17, 18, 19};
        int[] array = {19, 18, 17, 6, 4, 3, 2, 1};
        boolean rec = isSort(array);
        System.out.println(rec);




        //将数组逆序之后得到结果

//        String tmp = Arrays.toString(array);
//
//        StringBuffer tmp2 = new StringBuffer(tmp);
//
//        tmp2 = tmp2.reverse();
//
//        tmp = tmp2.toString();
//
//        int[] reverseArray = tmp.chars().toArray();
//
//
//        boolean flag = isSort(reverseArray);
//        System.out.println(flag);
    }








}
