package suanfa.day2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @PROJECT_NAME: suanfa
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/4 17:10
 */

public class Main2 {


    public static ArrayList<Integer> sub(ArrayList<Integer> a, ArrayList<Integer> b){

        int tmp = 0;

        ArrayList<Integer> c = new ArrayList<>();

        for (int i = 0; i < a.size(); i++){

            tmp = a.get(i) - tmp;

            if (i < b.size()) tmp = tmp - b.get(i);

            c.add((tmp + 10) % 10);

            if (tmp < 0) tmp = 1;
            else tmp = 0;

        }


        while (c.size() > 1 && c.get(c.size() - 1) == 0){

            c.remove(c.size() - 1);

        }


        return c;
    }


    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);

        String str1 = scaner.next();
        String str2 = scaner.next();

        ArrayList<Integer> A = new ArrayList<>();

        ArrayList<Integer> B = new ArrayList<>();


        for (int i = str1.length() - 1; i >= 0; i--){

            int tmp = str1.charAt(i) - '0';

            A.add(tmp);

        }

        for (int i = str2.length() - 1; i >= 0; i--){

            int tmp = str2.charAt(i) - '0';

            B.add(tmp);

        }

        if (cmp(A, B)){

            ArrayList<Integer> c = sub(A, B);

            for (int i = c.size() - 1; i >= 0; i--){
                System.out.print(c.get(i));

            }

        } else {

            ArrayList<Integer> c = sub(B, A);

            System.out.print("-");
            for (int i = c.size() - 1; i >=0; i--){

                System.out.print(c.get(i));
            }

        }


    }

    public static boolean cmp(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a.size() != b.size()) return a.size() > b.size();
        //相等从高位进行比较
        for(int i = a.size() - 1; i >= 0; i --){

            if(a.get(i) != b.get(i)) return a.get(i) > b.get(i);

        }
        return true;

    }

}
