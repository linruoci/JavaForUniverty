package demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @PROJECT_NAME: Test2022_9_4
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/4 23:16
 */
public class ReflectEnum {


    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> c3 = Class.forName("demo2.TestEnum");

        try {
            Constructor<?> tmp = c3.getDeclaredConstructor(String.class, int.class, String.class, int.class);

            tmp.setAccessible(true);

            TestEnum test = (TestEnum) tmp.newInstance("BLACK", 18);



            System.out.println(test);


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


}
