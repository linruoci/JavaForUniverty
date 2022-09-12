package day4;

import java.util.*;


//链接：https://www.nowcoder.com/questionTerminal/2cc32b88fff94d7e8fd458b8c7b25ec1
//
//
//        给定一个十进制数 M ，以及需要转换的进制数 N 。将十进制数 M 转化为 N 进制数。
//
//        当 N 大于 10 以后， 应在结果中使用大写字母表示大于 10 的一位，如 'A' 表示此位为 10 ， 'B' 表示此位为 11 。
//
//        若 M 为负数，应在结果中保留负号。




//这道题最巧的地方在于创建了一个String类型的table用来存储每一位数字， 这里太巧妙了。



public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public static String solve (int M, int N) {
        
        String table = "0123456789ABCDEF";
        
        StringBuilder ans = new StringBuilder();
        
        boolean flag = false;
        
        if (M < 0){
            
            M = -M;
            flag = true;
            
        }
        
        while (M > 0){
            
            ans.append(table.charAt(M % N));
            
            M  = M / N;
            
            
            
        }
        if (flag == true){
            
            ans.append("-");
            
        }
        ans = ans.reverse();
        return ans.toString();



    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int m = scanner.nextInt();

        int n = scanner.nextInt();

        String ret = solve(m, n);

        System.out.println(ret);



    }


}