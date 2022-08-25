import java.util.Arrays;
import java.util.Random;

/**
 * @PROJECT_NAME: TestDemo2022_8_24
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/24 20:14
 */
public class TestDemo {


    private static void insertSort(int[] arr){
        if (arr == null) return;

        for (int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--){

                if (arr[j] > tmp){

                    arr[j + 1] = arr[j];


                } else {

                    //arr[j + 1] = tmp;
                    break;
                }

            }
            arr[j + 1] = tmp;



        }




    }


    /**
     * 希尔排序
     * @param arr
     * @param gap
     */
    private static void shell(int[] arr, int gap) {

        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0; j-= gap) {

                if (arr[j] > tmp) {

                    arr[j + gap] = arr[j];

                } else {

                    //arr[j + 1] = tmp;
                    break;
                }

            }
            arr[j + gap] = tmp;

        }

    }
    public static void shellSort(int[] arr){
        int gap = 5;
        while (gap > 1){

            shell(arr, gap);
            gap /= 2;

        }
        shell(arr, 1);


    }




    /**
     * 选择排序
     * @param arr
     */

    private static void selectSort(int[] arr){
        if (arr == null) return;

        for (int i = 0; i < arr.length; i++){

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++){

                if (arr[j] < arr[minIndex]){

                    minIndex = j;

                }


            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;


        }



    }


    private static void shiftDown(int[] arr, int parent, int len){

        int children = 2 * parent + 1;
        while (children < len){

            if (children + 1 < len && arr[children + 1] > arr[children]){

                children++;
            }
            if (arr[children] > arr[parent]){

                int tmp = arr[children];
                arr[children] = arr[parent];
                arr[parent] = tmp;
                parent = children;
                children = 2 * parent + 1;


            } else {
                break;
            }

        }


    }

    private static void createHeap(int[] arr){


        for (int p = (arr.length - 1 -1) / 2; p >= 0; p--){


            shiftDown(arr, p, arr.length);

        }


    }

    /**
     * 堆排序
     * @param arr
     */

    public static void heapSort(int[] arr){

        createHeap(arr);
        int end = arr.length - 1;

        while (end >= 0){

            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;

            shiftDown(arr, 0, end);
            end--;


        }


    }






    public static void main(String[] args) {
        int[] arr = new int[1_0000];
        int j = 0;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++){

            arr[i] = random.nextInt();

        }
        System.out.println("排序前:" + Arrays.toString(arr));

        long begin = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("排序后:" + Arrays.toString(arr));
        System.out.println(end - begin);


    }




}