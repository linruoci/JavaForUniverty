import java.util.*;

/**
 * @PROJECT_NAME: Test2022_8_31
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/1 0:33
 */
public class Demo2 {


    public static void main(String[] args) {

        Set<String> set = new TreeSet<>();

        set.add("abc");
        set.add("abc");
        set.add("bcd");

        System.out.println(set);







    public static void main1(String[] args) {

        Map<String, Integer> map = new TreeMap<>();
        map.put("cdbab", 5);
        map.put("cdbab", 2);
        map.put("amsdj", 10);

        System.out.println(map);
        //System.out.println(map.get("hbsdn"));
        Set<Map.Entry<String, Integer>> tmp = map.entrySet();

        for (Map.Entry<String, Integer> i : tmp){

            System.out.println("Key为:" + i.getKey() + "value:" + i.getValue());

        }

    }


}
