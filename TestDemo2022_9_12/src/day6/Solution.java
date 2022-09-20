package day6;

import java.util.*;


//链接：https://www.nowcoder.com/questionTerminal/1277c681251b4372bdef344468e4f26e
//        来源：牛客网
//
//        将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为 0 或者字符串不是一个合法的数值则返回 0
//
//        注意：
//        ①字符串中可能出现任意符号，出现除 +/- 以外符号时直接输出 0
//        ②字符串中可能出现 +/- 且仅可能出现在字符串首位。

//测试案例:>输入
//        "+2147483647"
//        输出
//        2147483647

//输入： "1a33"
//        输出
//        0



public class Solution {
    public static int StrToInt(String str) {
    
        boolean flag = false;
        
        long ret = 0;
        
        
        
        for (int i = 0; i < str.length(); i++){
            
            char ch = str.charAt(i);
            //判断第一个字符是不是符号。
            if ((ch == '-' || ch == '+') && i == 0){
                
                if (ch == '-'){
                    flag = true;
                }
                continue;
            }
            
            //判断字符串中是否有其它字符。
            if ((ch < '0' && i != 0)|| (ch > '9' && i != 0)){
                
                return 0;
                
            }
            
            ret = ret * 10 + (ch - '0');
            
             
        }
    
        if (flag == true){
            
            return (int)-ret;
        }      
        return (int)ret;
        
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int ret = StrToInt(str);

        System.out.println(ret);



    }




}