package spring.test;

import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @DATE: 2022/10/29 10:26
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */

public class FirstSpringTest {

    @Test
    public void testBeginInitBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");


    }


    @Test
    public void testFirstSpringCore(){
        //1.获取Spring容器对象
        //resources目录是类的根路径
        //ClassPathXmlApplicationContext是专门从类路径中加载spring配置文件的一个spring上下文对象
        //这行代码一执行， 相当于启动spring容器， 解析配置文件， 同时把所有bean对象全部new出来， 放到我们的容器中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml", "beans.xml");

        //2.根据bean的id从spring中获取这个对象
        Object user = applicationContext.getBean("user");
        System.out.println(user);

        Object userDaoBean = applicationContext.getBean("userDaoBean");
        System.out.println(userDaoBean);


        Object vip = applicationContext.getBean("vip");
        System.out.println(vip);

        //1.这里是强转的写法
        Date nowTime = (Date) applicationContext.getBean("nowTime");
        //2.另一种写法
        Date nowTime2 = applicationContext.getBean("nowTime", Date.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(nowTime));



    }
}
