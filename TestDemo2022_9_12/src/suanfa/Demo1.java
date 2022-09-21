package suanfa;

import java.util.Arrays;
import java.util.Random;

/**
 * @PROJECT_NAME: TestDemo2022_9_12
 * @DESCRIPTION: 荷兰国旗问题的代码实现
 * @USER: 帅哥
 * @DATE: 2022/9/14 8:47
 */



public class Demo1 {



    private static void swap(int[] array, int x, int y){

        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;


    }



    private static void divisionArray(int[] array, int k){

        if (array == null || array.length == 0){

            return;

        }

        int lessArea = -1;
        int greatArea = array.length;

        int i = 0;

        while (i < greatArea){

            if(array[i] < k){

                swap(array, i++, ++lessArea);


            } else if (array[i] == k){

                i++;

            } else {


                swap(array, i, --greatArea);


            }


        }



    }



    public static void main(String[] args) {

        Random random = new Random();
        int length = random.nextInt(10);

        int[] array = new int[length];

        for (int i = 0; i < array.length; i++){

            array[i] = random.nextInt(10);


        }


        System.out.println(Arrays.toString(array));


        divisionArray(array, 5);

        System.out.println(Arrays.toString(array));


    }



}
