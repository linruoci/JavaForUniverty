package demo1;

import java.util.ArrayList;

class Solution {
    public int[] singleNumber(int[] nums) {
        int eor = 0;

        for (int cur : nums){


            eor ^= cur;

        }
        //此时eor = a ^ b;

        ArrayList<String> tmp = new ArrayList<>();

        StringBuilder str1 = new StringBuilder();
        str1.insert();


        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;
        for (int cur : nums){

            if ((cur & rightOne) == rightOne){

                onlyOne ^= cur;

            }

        }

        return new int[]{onlyOne, eor ^ rightOne};

        


    }
}