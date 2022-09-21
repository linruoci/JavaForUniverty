//package demo3;
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
///**
// * @PROJECT_NAME: Test2022_9_4
// * @DESCRIPTION:
// * @USER: 帅哥
// * @DATE: 2022/9/5 10:20
// */
//
//
////无返回值无参数 @FunctionalInterface
//interface NoParameterNoReturn { void test(); }//无返回值一个参数 @FunctionalInterface
//interface OneParameterNoReturn { void test(int a); }//无返回值多个参数 @FunctionalInterface
//interface MoreParameterNoReturn { void test(int a,String b); }//有返回值无参数 @FunctionalInterface
//interface NoParameterReturn { int test(); }
//
////有返回值一个参数 @FunctionalInterface
//interface OneParameterReturn { int test(int a); }//有返回值多参数 @FunctionalInterface
//interface MoreParameterReturn { int test(int a,int b); }
//
//
//
//public class Lambda {
//
//
//    public static void main(String[] args) {
//
//        int a = 10;
//        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//
//
//                System.out.println(a);
//                return 0;
//            }
//        });
//
//        PriorityQueue<Integer> queue1 = new PriorityQueue<>((o1, o2)->{
//
//            a = 200;
//            System.out.println(a);
//            return o1 - o2;
//
//        });
//
//    }
//
//
//
//    public static void main4(String[] args) {
//
//        NoParameterReturn noParameterReturn = () -> 10;
//
//
//        int test = noParameterReturn.test();
//
//        System.out.println(test);
//
//    }
//
//
//
//
//
//    public static void main3(String[] args) {
//
//        MoreParameterNoReturn moreParameterNoReturn = (a, b) ->{
//
//
//            System.out.println(a + " " + b);
//        };
//        moreParameterNoReturn.test(3, "nihap");
//
//    }
//
//
//
//    public static void main2(String[] args) {
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//
//
//        PriorityQueue<Integer> queue2 = new PriorityQueue<>((o1, o2)-> (o1 - o2));
//
//
//    }
//
//
//
//
//    public static void main1(String[] args) {
//
//
//        new NoParameterNoReturn() {
//            @Override
//            public void test() {
//                System.out.println("fafafa");
//            }
//        }.test();
//
//
//        NoParameterNoReturn noParameterNoReturn = () -> {
//
//            System.out.println("shuaige");
//
//        };
//
//    }
//
//
//
//
//}
