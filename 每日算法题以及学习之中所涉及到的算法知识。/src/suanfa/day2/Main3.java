package suanfa.day2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @PROJECT_NAME: suanfa
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/4 19:53
 * 高精度乘法的做法。
 */
public class Main3 {


    private static ArrayList<Integer> mul(ArrayList<Integer> a, int b){

        int tmp = 0;

        ArrayList<Integer> c = new ArrayList<>();

        for (int i = 0; i < a.size() || tmp > 0; i++){

            if (i < a.size()) {
                tmp = a.get(i) * b + tmp;
            }

            c.add(tmp % 10);

            tmp = tmp / 10;

        }

        return c;

    }


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String str = scan.next();

        int b = scan.nextInt();


        ArrayList<Integer> a = new ArrayList<>();

        for (int i = str.length() - 1; i >= 0; i--){

            a.add(str.charAt(i) - '0');

        }

        ArrayList<Integer> c = mul(a, b);

        for (int i = c.size() - 1; i>= 0; i--){

            System.out.print(c.get(i));

        }

    }

}
