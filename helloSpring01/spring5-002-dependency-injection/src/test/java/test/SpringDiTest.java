package test;

import jdbc.DBUtil;
import jdbc.DBUtil1;
import jdbc.DBUtil2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CustomerService;
import service.UserService;
import service.bean.*;

/**
 * @DATE: 2022/10/30 13:34
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class SpringDiTest {


    @Test
    public void testProperties(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties.xml");
        DBUtil ds = context.getBean("db", DBUtil.class);
        System.out.println(ds);


    }


    @Test
    public void testUtil(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-util.xml");
        DBUtil1 ds1 = context.getBean("ds1", DBUtil1.class);
        System.out.println(ds1);

        DBUtil2 ds2 = context.getBean("ds2", DBUtil2.class);
        System.out.println(ds2);


    }

    @Test
    public void testAutoWire(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.savaMessage();
    }

    @Test
    public void testP(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = context.getBean("dogBean", Dog.class);
        System.out.println(dogBean);

    }


    @Test
    public void testCollectionInsert(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person personBean = context.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testArrayInsert(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-array.xml");

        Guys guys = context.getBean("guys", Guys.class);
        System.out.println(guys);

    }

    @Test
    public void testCascaValue(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
        Student student = context.getBean("student", Student.class);

        Clazz clazz = context.getBean("clazz", Clazz.class);

        System.out.println(student);
        System.out.println(clazz);


    }

    @Test
    public void testSimpleValue(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
        SimpleValueType value = context.getBean("simpleValue", SimpleValueType.class);
        System.out.println(value);

    }

    @Test
    public void testConstructorDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        CustomerService csbean1 = applicationContext.getBean("csbean1", CustomerService.class);
        csbean1.save();


        CustomerService csbean2 = applicationContext.getBean("csbean2", CustomerService.class);
        csbean2.save();

    }

    @Test
    public void testSetDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService bean = applicationContext.getBean("userService", UserService.class);
        bean.savaMessage();
    }

}
