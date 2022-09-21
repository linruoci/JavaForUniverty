package demo2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < grid.length; i++) {


            for (int j = 0; j < grid[i].length; j++) {

                list.add(grid[i][j]);

            }
        }

        //现在我们把所有数据都存放在了一个一维数组上， 我们对一维数组进行操作
        while (k > 0){

            int length = list.size();
            int tmp = list.get(length - 1);
            list.remove(length - 1);
            list.add(0, tmp);

            k--;


        }

        int p = 0;



        for (int i = 0; i < m; i++){
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < n; j++){

                tmpList.add(list.get(p++));

            }
            result.add(tmpList);
        }

        return result;
    }
}