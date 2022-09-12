package day3;

import java.util.HashMap;
import java.util.Map;

/**
 * @PROJECT_NAME: TestDemo2022_9_12
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/12 9:05
 */

//https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
//        来源:牛客网
//
//        给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//        例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
//
//        数据范围: n≤50000，数组中元素的值 0≤val≤10000
//        要求：空间复杂度：O(1)O(1)，时间复杂度 O(n)O(n)


public class Main2 {

    /**
     * 哈希表的运用。
     */
//    public int MoreThanHalfNum_Solution(int [] array) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < array.length; i++){
//
//            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
//
//
//        }
//        for (int i = 0; i < array.length; i++){
//
//
//            int size = array.length;
//
//            if (map.get(array[i]) > (size / 2)){
//
//                return array[i];
//
//            }
//
//
//        }
//        return -1;
//
//
//
//    }


    //下面展示摩尔投票法的使用， 摩尔投票法适用于找出数组中存在一半以上的数。
    public int MoreThanHalfNum_Solution(int [] array) {

        int result = array[0];
        int times = 1;

        for (int i = 1; i < array.length; i++){

            if (times != 0){

                if (array[i] != result){

                    times--;

                } else {

                    times++;

                }
            } else {

                result = array[i];
                times = 1;



            }


        }

        //这样我们就找到了那个超过数组长度一半的数。

        //如果这道题描述了说，如果不存在这个数， 则返回0的话， 我们还需要对result进行检查。

//        int count = 0;
//
//        for (int i = 0; i < array.length; i++){
//
//            if (array[i] == result){
//
//                count++;
//
//            }
//
//        }
//
//        if (count > (array.length / 2)){
//            return result;
//
//        } else {
//
//            return 0;
//
//       }
        return result;



    }





}
