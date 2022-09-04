package reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @PROJECT_NAME: Test2022_9_4
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/4 21:54
 */
public class ReflectClassDemo {


    public static void reflectNewInstance(){

        try {
            Class<?> c1 = Class.forName("reflectdemo.Student");

            //通过反射获取一个学生对象
            Student student = (Student)c1.newInstance();
            System.out.println(student);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }



    public static void reflectPrivateConstructor(){


        try {
            Class<?> c3 = Class.forName("reflectdemo.Student");


            Constructor<?> t =  c3.getDeclaredConstructor(String.class, int.class);


            t.setAccessible(true);
            Student student = (Student)t.newInstance("ruoci", 18);

            System.out.println(student);

            //通过反射获取一个学生对象

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }


    public static void reflectPrivateField(){

        try {
            Class<?> c3 = Class.forName("reflectdemo.Student");


            Student student = (Student)c3.newInstance();

            Field field = c3.getDeclaredField("name");


            field.setAccessible(true);

            field.set(student, "linruoci");

            System.out.println(student);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

    public static void reflectPrivateMethod(){

        try {
            Class<?> c3 = Class.forName("reflectdemo.Student");

            Student student = (Student)c3.newInstance();


            Method method = c3.getDeclaredMethod("function", String.class);


            method.setAccessible(true);

            method.invoke(student, "你是一只猪");




        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }





    public static void main(String[] args) {

//        reflectNewInstance();
//
//        //reflectPrivateConstructor();
//
//        reflectPrivateField();


        reflectPrivateMethod();

    }




}
