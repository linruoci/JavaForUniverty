package demo2;

import java.util.Arrays;
import java.util.List;

/**
 * @PROJECT_NAME: TestDemo2022_8_24
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/8/31 0:15
 */
public class Test {


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        List<List<Integer>> result = solution.shiftGrid(grid, 4);
        System.out.println(result);


    }

}
