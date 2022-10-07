package day2;
import java.lang.reflect.Array;
import java.util.*;
/**
 * @DATE: 2022/10/7 23:39
 * @PROJECT_NAME: acwing
 * @author: 帅哥
 * @DESCRIPTION: 这个类用来演示高精度加法。
 */


public class Demo1 {


    private static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b){

        ArrayList<Integer> c = new ArrayList<>();

        int ans = 0;

        for (int i = 0; i < a.size() || i < b.size(); i++) {

            if (i < a.size()) ans += a.get(i);
            if (i < b.size()) ans += b.get(i);

            c.add(ans % 10);

            ans = ans / 10;


        }

        if (ans > 0){
            c.add(1);
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

        ArrayList<Integer> c = add(arrayA, arrayB);

        for (int i = c.size() - 1; i >= 0; i--){

            System.out.print(c.get(i));

        }



    }

}
