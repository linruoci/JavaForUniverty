package day6;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @PROJECT_NAME: TestDemo2022_9_12
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/9/19 13:01
 */

//链接：https://www.nowcoder.com/questionTerminal/1183548cd48446b38da501e58d5944eb?source=relative
//        来源：牛客网
//
//        二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
//        对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
//        ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
//        小易想知道最多可以放多少块蛋糕在网格盒子里。
//


/**
 * @author 帅哥
 */

public class Solution2{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] array = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++){

            for (int j = 0; j < n; j++){

                if (array[i][j] == 0){
                    ans++;

                    if (i + 2 < m){

                        array[i+2][j] = -1;

                    }
                    if (j + 2 < n){

                        array[i][j+2] = -1;

                    }

                }


            }

        }

        System.out.println(ans);


    }

}
