package demo3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {


        String str = "abcdef";
        str.toCharArray();


        Map<Integer, Integer> map = new HashMap<>();

        map.put(nums[0], 0);


        for (int i = 1; i < nums.length; i++){


            if (map.containsKey(target - nums[i])){

                
                return new int[]{map.get(target - nums[i]), nums[i]};

            }

            map.put(nums[i], i);
            

        }
        

        return new int[0];

    }
}