import java.lang.reflect.Array;
import java.util.*;

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


    private static int partitionHoare(int[] arr, int low, int high){

        int i = low;
        int tmp = arr[i];

        while (low < high){


            while (low < high && arr[high] >= tmp){

                high--;

            }



            while (low < high && arr[low] <= tmp){

                low++;

            }
            swap(arr, low, high);

        }

        swap(arr, low, i);

        return low;

    }


    private static int partitionHole(int[] arr, int low, int high){
        int i = low;
        int tmp = arr[low];


        while (low < high){

            while (low < high && arr[high] >= tmp){

                high--;

            }
            arr[low] = arr[high];


            while (low < high && arr[low] <= tmp){

                low++;
            }
            arr[high] = arr[low];


        }
        arr[low] = tmp;
        return low;



    }



    private static int partition1(int[] arr, int low, int high){

        int d = low + 1;
        int pivot = arr[low];

        for (int i = low + 1; i <= high; i++){

            if (arr[i] < pivot){

                swap(arr, d, i);
                d++;

            }


        }

        swap(arr, d - 1, low);
        return d - 1;


    }




    private static int mediumOfThree(int[] arr, int left, int right){

        int mid = left + ((right - left) >> 1);

        if (arr[left] < arr[right]){

            if (arr[mid] < arr[left]){

                return left;

            } else if (arr[mid] > arr[right]){

                return right;

            } else {

                return mid;

            }

        } else {

            if (arr[mid] < arr[right]){

                return right;

            } else if (arr[mid] > arr[left]){


                return left;

            } else {


                return mid;

            }



        }





    }

    private static void quick(int[] arr, int left, int right){

        if (left >= right) return;


        if (right - left + 1 < 70000){
          insertSort(arr);
          return;
        }

        int index = mediumOfThree(arr, left, right);
        swap(arr, index, left);


        int pivot = partitionHole(arr, left, right);
        quick(arr, left, pivot - 1);
        quick(arr, pivot + 1, right);




    }


    private static void quickSortNor(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        Stack<Integer> stack = new Stack<>();

        int pivot = partitionHole(arr, left, right);

        //说明左边还有数据
        if (pivot > left + 1){
            stack.push(left);
            stack.push(pivot - 1);

        }

        if (pivot < right - 1){

            stack.push(pivot + 1);
            stack.push(right);

        }

        while (!stack.isEmpty()){

            right = stack.pop();
            left = stack.pop();


            pivot = partitionHole(arr, left, right);

            //说明左边还有数据
            if (pivot > left + 1){
                stack.push(left);
                stack.push(pivot - 1);

            }

            if (pivot < right - 1){

                stack.push(pivot + 1);
                stack.push(right);

            }


        }



    }






    public static void quickSort(int[] arr){

         quick(arr, 0, arr.length- 1);


    }



    private static void swap(int[] arr, int a, int b){

        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;



    }



    private static void merge(int[] arr, int left, int right, int mid) {

        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;


        int[] tmpArray = new int[right - left + 1];
        int k = 0;

        while (s1 <= e1 && s2 <= e2){

            if (arr[s1] <= arr[s2]){

                tmpArray[k++] = arr[s1++];


            } else {

                tmpArray[k++] = arr[s2++];

            }


        }

        while (s1 <= e1){

            tmpArray[k++] = arr[s1++];

        }

        while (s2 <= e2){


            tmpArray[k++] = arr[s2++];

        }

        for (int i = 0; i < tmpArray.length; i++){


            arr[i + left] = tmpArray[i];


        }


    }

    private static void mergeSortIntenar(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = (left + right) / 2;

        mergeSortIntenar(arr, left, mid);
        mergeSortIntenar(arr, mid + 1, right);

        merge(arr, left, right, mid);

    }


    /**
     * 归并排序算法的实现
     * @param arr
     */

    public static void mergeSort(int[] arr){

        mergeSortIntenar(arr, 0, arr.length - 1);


    }

    Map<String, Integer> map = new TreeMap<>();
    /**
     * 归并排序算法非递归的实现。
     * @param arr
     */

    public static void mergeSortNor(int[] arr){

        int gap = 1;

        while (gap < arr.length){

            for (int i = 0; i < arr.length; i+= 2*gap){

                int left = i;
                int mid = left + gap - 1;

                if (mid >= arr.length){

                    mid = arr.length - 1;

                }

                int right = mid + gap;
                if (right >= arr.length){

                    right = arr.length - 1;

                }
                merge(arr, left, right, mid);


            }
            gap *= 2;

        }



    }

    /**
     * 计数排序的实现。
     * @param arr
     */

    public static void countSort(int[] arr){

        int minValue = arr[0];
        int maxValue = arr[0];

        for (int i = 1; i < arr.length; i++){

            if (arr[i] < minValue){

                minValue = arr[i];

            }

            if (arr[i] > maxValue){

                maxValue = arr[i];


            }

        }

        //到这里结束， minValue 和 maxValue 分别存的是数组的最大值和数组的最小值。

        int range = maxValue - minValue + 1;
        int[] tmpArr = new int[range];

        for (int i = 0; i < arr.length; i++){

            tmpArr[arr[i] - minValue]++;

        }
        //最后将我们的数据放回我们的数组

        int index = 0;

        for (int i = 0; i < tmpArr.length; i++){

            while (tmpArr[i] > 0){

                arr[index] = i + minValue;
                tmpArr[i]--;
                index++;
            }


        }



    }


    public static void main(String[] args) {
        int[] arr = {6,1,6,3,4,2,10,9,36,45,8,19};
        System.out.println("排序前" + Arrays.toString(arr));
        countSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));

    }



    public static void main2(String[] args) {

        int[] arr = new int[10_0000];

        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--){

            arr[j] = i;
            j++;
        }

        long begin = System.currentTimeMillis();
        mergeSort(arr);
        long end = System.currentTimeMillis();

        System.out.println("归并排序" + (end - begin));



    }



    public static void main1(String[] args) {
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