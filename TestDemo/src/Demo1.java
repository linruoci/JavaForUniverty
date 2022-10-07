import java.util.*;

/**
 * @PROJECT_NAME: TestDemo
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/6 22:46
 */
public class Demo1 {


    public static void main(String[] args) {

//        HashMap<String, Integer> map = new HashMap<>();
//
//        map.put("zhangsan", 1);
//        map.put("lisi", 4);
//
//        map.put("wangwu", 6);
//
//        Set<String> strings = map.keySet();
//
////        Iterator<String> it = strings.iterator();
//
////        while (it.hasNext()){
////
////            String x = it.next();
////            System.out.println(x + " " + map.get(x));
////
////        }
////        for (String x: strings){
////
////            System.out.println(x + " " + map.get(x));
////
////        }
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> it = entries.iterator();
//
//        while (it.hasNext()){
//
//            System.out.println(it.next());
//
//        }

        Car[] car = new Car[3];

        car[0] = new Car(12, 3.0);

        car[1] = new Car(4, 2.0);

        car[2] = new Car(8, 4.0);


        Arrays.sort(car, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return 0;
            }
        });
        System.out.println(Arrays.toString(car));
    }
}

class Car{

    int position;

    double time;

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", time=" + time +
                '}';
    }

    public Car(int position, double time){

        this.position = position;
        this.time = time;


    }




}