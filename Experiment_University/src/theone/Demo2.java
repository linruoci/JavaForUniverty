package theone;

import java.util.Arrays;

/**
 * @PROJECT_NAME: Experiment_University
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/9/28 8:26
 */

public class Demo2 {


    private static void swap(int[] array, int a, int b){

        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;

    }

    public static void reverse(int[] array){

        if (array == null) {
            return;
        }

        int left = 0;
        int right = array.length - 1;


        while (left < right){

            swap(array, left++, right--);


        }


    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("逆序前：" + Arrays.toString(array));

        reverse(array);
        System.out.println("逆序后：" + Arrays.toString(array));


    }


}
