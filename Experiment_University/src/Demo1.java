/**
 * @PROJECT_NAME: Experiment_University
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/9/26 23:32
 */

import java.util.*;

public class Demo1 {


    /**
     * 求最大公约数
     * @param m
     * @param n
     * @return
     */
    private static int gcd(int m, int n){


        return m % n == 0 ? n : gcd(n, m % n);


    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();

        int n = scan.nextInt();


        if (m <= 0 || n <= 0){

            System.out.println("新年快乐");
            return;

        }


        int result = gcd(m, n);



        System.out.println(result);



    }


}
