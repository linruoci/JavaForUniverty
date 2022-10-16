package day2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @DATE: 2022/10/8 9:10
 * @PROJECT_NAME: acwing
 * @author: 帅哥
 * @DESCRIPTION: 高精度减法的写法
 */


public class Demo2 {




    private static ArrayList<Integer> sub(ArrayList<Integer> a, ArrayList<Integer> b){

        int t = 0;
        ArrayList<Integer> c = new ArrayList<>();


        for (int i = 0; i < a.size(); i++){

            t = a.get(i) - t;

            if (i < b.size()) t = t - b.get(i);

            c.add((t + 10) % 10);

            if (t < 0) t = 1;
            else t = 0;


        }

        //去掉前导0；

        while (c.size() > 1 && c.get(c.size() - 1) == 0){

            c.remove(c.size() - 1);

        }

        return c;


    }



    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String a = scan.next();
        String b = scan.next();


        ArrayList<Integer> arrayA = new ArrayList<>();
        ArrayList<Integer> arrayB = new ArrayList<>();

        for (int i = a.length() - 1; i >= 0; i--){

            arrayA.add(a.charAt(i) - '0');

        }

        for (int i = b.length() - 1; i >= 0; i--){

            arrayB.add(b.charAt(i) - '0');

        }

        boolean flag = cmp(a, b);


        if (flag){

            ArrayList<Integer> c = sub(arrayA, arrayB);

            for (int i = c.size() - 1; i >= 0; i--){

                System.out.print(c.get(i));


            }
        } else {

            ArrayList<Integer> c = sub(arrayB, arrayA);
            System.out.print("-");
            for (int i = c.size() - 1; i >= 0; i--){

                System.out.print(c.get(i));


            }

        }


    }


    private static boolean cmp(String a, String b){

        if (a.length() != b.length()) return a.length() > b.length();

        for (int i = 0; i < a.length(); i++){

            if (b.charAt(i) != a.charAt(i)){

                return a.charAt(i) > b.charAt(i);

            }


        }

        return true;
    }


}
