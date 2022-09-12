package day3;

/**
 * @PROJECT_NAME: TestDemo2022_9_12
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/12 8:54
 */

//读入一个字符串str，输出字符串str中的连续最长的数字串
//其实思路非常的简单， 就是遍历到数字，我们就将它加起来， 然后去比较一下大小就可以了。

import java.util.*;


public class Main{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();


        StringBuilder cur = new StringBuilder();
        String ans = "";

        for (int i = 0; i < str1.length(); i++){

            char ch = str1.charAt(i);

            if (ch >= '0' && ch <= '9'){

                cur.append(ch);


            } else {

                String tmp = cur.toString();
                if (tmp.length() > ans.length()){

                    ans = tmp;

                }
                cur = new StringBuilder();
            }


        }

        String tmp = cur.toString();
        if (tmp.length() > ans.length()){

            ans = tmp;

        }

        System.out.println(ans);




    }


}
