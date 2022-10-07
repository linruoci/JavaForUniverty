package suanfa.day2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @PROJECT_NAME: suanfa
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/4 21:48
 */
public class Main4 {

    static Integer rest = 0;

    private static ArrayList<Integer> div(ArrayList<Integer> a, int b){



        ArrayList<Integer> c = new ArrayList<>();


        for (int i = a.size() - 1; i >= 0; i--){

            rest = rest * 10 + a.get(i);

            c.add(rest / b);

            rest %= b;

        }



        ArrayList<Integer> array = new ArrayList<>();

        int k = 0;

        for (int i = c.size() - 1; i >= 0; i--){

            array.add(c.get(i));

        }


        while (array.size() > 1 && array.get(array.size() - 1) == 0){

            array.remove(array.size() - 1);

        }


        return array;





    }


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String str = scan.next();

        int b = scan.nextInt();


        ArrayList<Integer> a = new ArrayList<>();

        for (int i = str.length() - 1; i >= 0; i--){

            a.add(str.charAt(i) - '0');

        }


        ArrayList<Integer> c = div(a, b);

        for (int i = c.size() - 1; i>= 0; i--){

            System.out.print(c.get(i));

        }
        System.out.println();
        System.out.println(rest);
    }


}
