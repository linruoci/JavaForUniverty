import java.util.Comparator;
import java.util.PriorityQueue;




class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++){

            queue.offer(stones[i]);

        }


        while (queue.size() > 1){



            int max = queue.poll();
            int secondMax = queue.poll();

            if (max - secondMax != 0){

                queue.offer(max - secondMax);

            }
        }
        return queue.peek();
    }
}