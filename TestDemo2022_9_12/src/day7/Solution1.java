package day7;

/**
 * @PROJECT_NAME: TestDemo2022_9_12
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/21 8:18
 */

//链接：https://www.nowcoder.com/questionTerminal/d8acfa0619814b2d98f12c071aef20d4
//        来源：牛客网
//
//        给定一个字符串A和其长度n，请返回一个bool值代表它是否为一个合法的括号串（只能由括号组成）。
//
//        测试样例：
//        "(()())",6
//        返回：true
//        测试样例：
//        "()a()()",7
//        返回：false
//        测试样例：
//        "()(()()",7
//        返回：false



import java.util.*;

public class Solution1 {

    public boolean chkParenthesis(String A, int n) {
        // write code here
        if (n % 2 == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < A.length(); i++){

            char ch = A.charAt(i);

            if (ch == '('){

                stack.push(ch);

            } else if (ch == ')'){

                if (stack.isEmpty()){

                    return false;

                } else {

                    stack.pop();

                }

            } else {

                return false;

            }


        }
        return true;

    }
}
