package day2;
import java.util.*;
/**
 * @DATE: 2022/10/9 0:13
 * @PROJECT_NAME: acwing
 * @author: 帅哥
 * @DESCRIPTION: 高精度乘法的代码。
 */


public class Demo3 {


    private static ArrayList<Integer> mul(ArrayList<Integer> a, int b){

        //先定义一个答案
        ArrayList<Integer> c = new ArrayList<>();
        if (b == 0) {
            c.add(0);
            return c;
        }
        int t = 0;

        for (int i = 0; i < a.size() || t > 0; i++){

            if (i < a.size()) t = a.get(i) * b + t;

            c.add(t % 10);

            t = t / 10;

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
        ArrayList<Integer> c = mul(arrayA, b);

        for (int i = c.size() - 1; i >= 0; i--){

            System.out.print(c.get(i));

        }


    }

}
