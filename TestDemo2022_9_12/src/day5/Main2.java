package day5;

/**
 * @PROJECT_NAME: TestDemo2022_9_12
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/12 15:51
 */
import java.util.*;



//链接：https://www.nowcoder.com/questionTerminal/5a304c109a544aef9b583dce23f5f5db
//        [编程题]连续最大和
//
//        一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
//
//        输入描述:
//        输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。






public class Main2{




    private static int merge(int[] array, int left, int mid, int right){

        int s1 = left;
        int e1 = mid;

        int s2 = mid + 1;
        int e2 = right;

        int[] tmpArray = new int[right - left + 1];

        int k = 0;

        int ans = 0;


        while (s1 <= e1 && s2 <= e2){

            if (array[s1] < array[s2]){

                ans += array[s1] * (e2 - s2 + 1);
                tmpArray[k++] = array[s1++];

            } else {

                tmpArray[k++] = array[s2++];


            }
        }

        while (s1 <= e1){

            tmpArray[k++] = array[s1++];



        }

        while (s2 <= e2){

            tmpArray[k++] = array[s2++];

        }

        return ans;


    }




    private static int mergeSortIntenal(int[] array, int left, int right){
        if (left >= right) return 0 ;



        int mid = left + ((right - left) >> 1);


        return mergeSortIntenal(array, left, mid) + mergeSortIntenal(array, mid + 1, right) + merge(array, left, mid, right);




    }




    private static int mergeSort(int[] array){

        int ans = mergeSortIntenal(array, 0, array.length - 1);
        return ans;

    }


    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 5};
        int ret = mergeSort(arr);
        System.out.println(ret);



    }








    private static int getMax(int a, int b){

        return Math.max(a, b);


    }



    public static void main1(String[] args){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++){

            array[i] = scan.nextInt();

        }

        int max = array[0];
        int sum = array[0];

        for (int i = 1; i < array.length; i++){

            sum = getMax(sum + array[i], array[i]);

            if (sum >= max){

                max = sum;


            }


        }

        System.out.println(max);

    }

}