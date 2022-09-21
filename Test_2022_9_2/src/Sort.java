import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @PROJECT_NAME: Test_2022_9_2
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/3 9:50
 */
public class Sort {





    public static void insertSort(int[] array){

        for (int i = 1; i < array.length; i++){

            int tmp = array[i];
            int j = i - 1;
            for (; j < array.length; j++){

                if (array[j] > tmp){

                    array[j + 1] = array[j];


                } else {

                    //array[j + 1] = tmp;
                    break;

                }


            }

            array[j + 1] = tmp;



        }


    }


    /**
     * 归并排序的递归写法。
     * @param array
     */
    public static void mergeSort(int[] array){

        mergeSortIntenal(array, 0, array.length - 1);
    }

    private static void mergeSortIntenal(int[] array, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;

        mergeSortIntenal(array, left, mid);
        mergeSortIntenal(array, mid + 1, right);


        merge(array, left, mid, right);



    }

    private static void merge(int[] array, int left, int mid, int right) {

        int s1 = left;
        int e1 = mid;

        int s2 = mid + 1;
        int e2 = right;

        int[] tmpArray = new int[right - left + 1];

        int i = 0;


        while (s1 <= e1 && s2 <= e2){


            if (array[s1] < array[s2]){

                tmpArray[i++] = array[s1++];

            } else {

                tmpArray[i++] = array[s2++];

            }


        }

        while (s1 <= e1){

            tmpArray[i++] = array[s1++];

        }

        while (s2 <= e2){

            tmpArray[i++] = array[s2++];

        }

        for (int j = 0; j < tmpArray.length; j++){

            array[j + left] = tmpArray[j];

        }


    }

    /**
     * 接下来写一个不是递归的算法。
     * @param array
     *
     *
     */


    public static void mergeSortNor(int[] array){

        int gap = 1;
        while (gap < array.length){


            for  (int i = 0; i < array.length; i += 2 * gap){

                int left = i;
                int mid = left + gap - 1;

                if (mid >= array.length){

                    mid = array.length - 1;


                }

                int right = mid + gap;

                if (right >= array.length){

                    right = array.length - 1;


                }

                merge(array, left, mid, right);




            }
            gap *= 2;


        }



    }

    private static void swap(int[] array, int a, int b){

        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;


    }


    private static int partitionHoare(int[] array, int low, int high){

        int i = low;
        int tmp = array[low];

        while (low < high){

            while (low < high && array[high] >= tmp){

                high--;

            }
            while (low < high && array[low] <= tmp){


                low++;

            }
            swap(array, low, high);


        }

        swap(array, low ,i);
        return low;


    }


    private static int partitionHole(int[] array, int low, int high){

        int tmp = array[low];


        while (low < high){

            while (low < high && array[high] >= tmp){

                high--;

            }
            array[low] = array[high];


            while (low < high && array[low] <= tmp){

                low++;


            }
            array[high] = array[low];



        }

        array[low] = tmp;
        return low;


    }

    private static int partition1(int[] array, int low, int high){

        int d = low + 1;
        int tmp = array[low];

        for (int i = low + 1; i <= high; i++){

            if (array[i] < tmp){

                swap(array, d, i);
                d++;

            }

        }
        swap(array, low, d - 1 );
        return d - 1;


    }

    public static void insertSortRange(int[] array, int left, int right){

        for (int i = left + 1; i <= right; i++){

            int tmp = array[i];
            int j = i - 1;
            for (; j >= left; j--){

                if (array[j] > tmp){

                    array[j + 1] = array[j];


                } else {

                    //array[j + 1] = tmp;
                    break;

                }


            }

            array[j + 1] = tmp;



        }


    }


    private static int mediumOfThree(int[] array, int left, int right){

        int mid = (left + right) / 2;


        if (array[left] < array[right]){

            if (array[mid] < array[left]){
                return left;
            } else if (array[mid] > array[right]){

                return right;

            } else {

                return mid;

            }


        } else {

            if (array[mid] < array[right] ){

                return right;

            } else if (array[mid] > array[left]){

                return left;

            } else {
                return mid;

            }


        }





    }


    private static void quick(int[] array, int low, int high){

        if (low >= high){

            return;

        }

        if (high - low + 1 <= 15){

            insertSortRange(array, low, high);
            return;
        }

        int index = mediumOfThree(array, low, high);
        swap(array, low, index);


        int pivot = partitionHole(array, low, high);
        quick(array, low, pivot - 1);
        quick(array, pivot + 1, high);


    }


    private static void shiftDown(int[] array, int p, int len){

        int parent = p;
        int children = 2 * parent + 1;

        while (children < len){

            if (children + 1 < len && array[children + 1] > array[children]){

                children++;


            }

            if (array[children] > array[parent]){

                swap(array, children, parent);

                parent = children;
                children = 2 * parent + 1;

            } else {

                break;

            }


        }







    }


    private static void createTree(int[] array){


        for (int p = (array.length - 1 - 1) / 2; p >= 0; p--){

            shiftDown(array, p, array.length);


        }

    }


    public static void heapSort(int[] array){

        createTree(array);
        int end = array.length - 1;
        while (end >= 0){

            swap(array, 0, end);
            shiftDown(array, 0, end);
            end--;

        }
    }







    public static void quickSort(int[] array){

        quick(array, 0, array.length - 1);

    }

    // 非递归实现快速排序
    public static void quickSortNor(int[] array){

        int left = 0;
        int right = array.length - 1;

        Stack<Integer> stack = new Stack<>();

        int pivot = partitionHole(array, left, right);

        if (pivot > left + 1){

            stack.push(pivot - 1);
            stack.push(left);


        }

        if (pivot < right - 1){

            stack.push(right);
            stack.push(pivot + 1);

        }


        while (!stack.isEmpty()){

            left = stack.pop();
            right = stack.pop();

            pivot = partitionHole(array, left, right);

            if (pivot > left + 1){

                stack.push(pivot - 1);
                stack.push(left);


            }

            if (pivot < right - 1){

                stack.push(right);
                stack.push(pivot + 1);

            }


        }







    }






    public static void main(String[] args) {

        int[] arr = {10, 6, 7, 1, 3, 9, 4, 2, 11};

//        int[] arr = new int[10_00000];
//        Random random = new Random();
//
//        for (int i = 0; i < arr.length; i++){
//
//            arr[i] = random.nextInt(10_00000);
//
//        }

        long begin = System.currentTimeMillis();
        //quickSort(arr);
        heapSort(arr);
        long end = System.currentTimeMillis();

        //System.out.println("快速排序:" + (end - begin));

        //mergeSortNor(arr);
        System.out.println(Arrays.toString(arr));


    }



}
