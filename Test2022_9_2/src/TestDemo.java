import java.util.*;

/**
 * @PROJECT_NAME: Test2022_9_2
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/2 9:01
 */
public class TestDemo {

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word :words){

            map.put(word, map.getOrDefault(word, 0) + 1);

        }
        //在这， map已经记录了所有单词出现的次数
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {


                if (o1.getValue().compareTo(o2.getValue()) == 0){

                    return o2.getKey().compareTo(o1.getKey());

                }

                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()){

            if (queue.size() < k){

                queue.offer(entry);

            } else {

                Map.Entry<String, Integer> top = queue.peek();
                Integer val = top.getValue();
                if (val.compareTo(entry.getValue()) < 0){

                    queue.poll();
                    queue.offer(entry);


                } else if (val.compareTo(entry.getValue()) == 0){

                    String key = top.getKey();

                    if (key.compareTo(entry.getKey()) > 0){

                        queue.poll();
                        queue.offer(entry);


                    }

                }


            }


        }

        List<String> ans = new ArrayList<>();


        for (int i = 0; i < k; i++){

            String tmp = queue.poll().getKey();
            ans.add(tmp);

        }


        Collections.reverse(ans);

        return ans;


    }

    public static void func1(int[] array){
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++){

            set.add(array[i]);

        }


    }


    public static int func2(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++){

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }


        for (int i = 0; i < arr.length; i++){

            if (map.get(arr[i]) == 1){

                return arr[i];

            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[10_0000];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++){

            arr[i] = random.nextInt(1_0000);

        }

        func1(arr);


    }





    public static void main1(String[] args) {

        String[] words = {"i","love","leetcode","i","love","coding", "love", "i"};

        List<String> list = topKFrequent(words, 1);

        System.out.println("fafafa");

    }


}
