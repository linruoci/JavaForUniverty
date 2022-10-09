package day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @DATE: 2022/10/9 9:10
 * @PROJECT_NAME: acwing
 * @author: 帅哥
 * @DESCRIPTION: 高精度除法代码java版。
 */
public class Demo4 {

    private static ArrayList<Integer> div(ArrayList<Integer> a, int b){

        ArrayList<Integer> c = new ArrayList<>();

        int t = 0;

        for (int i = a.size() - 1; i >= 0; i--){

            t = t * 10 + a.get(i);

            c.add(t / b);

            t = t % b;

        }
        Collections.reverse(c);

        //去掉前导0；

        while (c.size() > 1 && c.get(c.size() - 1) == 0){

            c.remove(c.size() - 1);

        }
        return c;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();

        int b = scan.nextInt();

        //将a逆序存在一个顺序表当中。

        ArrayList<Integer> arrayA = new ArrayList<>();

        for (int i = a.length() - 1; i >= 0; i--){

            arrayA.add(a.charAt(i) - '0');


        }
//        开始计算
        ArrayList<Integer> c = div(arrayA, b);

        for (int i = c.size() - 1; i >= 0; i--){

            System.out.print(c.get(i));

        }


    }
}
