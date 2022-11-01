package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CustomerService;
import service.UserService;
import service.bean.Clazz;
import service.bean.Guys;
import service.bean.SimpleValueType;
import service.bean.Student;

/**
 * @DATE: 2022/10/30 13:34
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class SpringDiTest {

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
