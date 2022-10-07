package suanfa.day2;
import java.lang.reflect.Array;
import java.util.*;
/**
 * @PROJECT_NAME: suanfa
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/4 15:55
 *
 *
 * 高精度加法的做法。
 *
 */
public class Main {


    public static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b){

        ArrayList<Integer> c = new ArrayList<>();

        int t = 0;


        for (int i = 0; i < a.size() || i < b.size(); i++){

            if (i < a.size()) t += a.get(i);

            if (i < b.size()) t += b.get(i);

            c.add(t % 10);

            t += 10;

        }

        if (t > 0){
            c.add(t);
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

        ArrayList<Integer> c = add(A, B);

        for (int i = c.size() - 1; i >=0; i--){

            System.out.print(c.get(i));

        }
        
    }


}
