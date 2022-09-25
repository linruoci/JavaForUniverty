package suanfa;

import java.util.Scanner;

/**
 * @PROJECT_NAME: TestDemo2022_9_12
 * @DESCRIPTION:
 * @DATE: 2022/9/25 9:03
 *
 * @author 帅哥
 */



public class BinarySearch {

    static double eps = 1e-8;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();

        double left = 0;

        double right = 10000;

        while (right- left > eps){

            double mid = (right + left) / 2;

            if (mid * mid >= x){

                right = mid;

            } else  {
                left = mid;

            }


        }

        System.out.printf("%f", left);


    }


    /**
     * 下面为整数二分基本模板
     * @param args
     */
    public static void main1(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 8, 9, 10};

        int left = 0;
        int right = array.length - 1;

        int k = 8;

        while (left < right){

            int mid = (left + right + 1) / 2;

            if (array[mid] <= k){

                left = mid;

            } else {

                right = mid -  1;

            }




        }
        if  (array[left] != k){

            System.out.println("没找到");

        } else {

            System.out.println(left + " " + array[left]);

        }

    }


}
