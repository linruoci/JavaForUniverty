import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);


        }
        Collections.sort(new ArrayList<String>(), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        for (int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if (map.get(ch) == 1){

                return i;

            }


        }

        return -1;
    }
}