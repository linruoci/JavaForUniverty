package reflectdemo;


public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException {

        //获取Class对象的第一种方式。
        Student student = new Student();
        Class<?> c1 = student.getClass();

        //获取Class对象的第二种方式。
        Class<?> c2 = Student.class;

        //获取Class对象的第三种方式。

        Class<?> c3 = Class.forName("reflectdemo.Student");

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c2 == c3);





    }



}
