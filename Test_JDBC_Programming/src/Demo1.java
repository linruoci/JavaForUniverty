import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @DATE: 2022/10/16 9:56
 * @PROJECT_NAME: Test_JDBC_Programming
 * @author: 帅哥
 * @DESCRIPTION: 使用JDBC获取数据库链接
 */
public class Demo1 {


    public static void main(String[] args) throws SQLException {


        //用dataSource来描述数据库的位置
        //此外， DataSource是一个接口， 不能直接实例化， MysqlDataSource则是实现了这个接口, 向上转型!
        DataSource dataSource = new MysqlDataSource();


        //向下转型! 描述数据库的位置
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java104?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("qwe00321..");


        //和数据库建立连接, 使用dataSource.getConnection.

        Connection connection = dataSource.getConnection();
        //System.out.println(connection);

        System.out.println("请输入学号:>");
        Scanner scan = new Scanner(System.in);

        int id = scan.nextInt();

        System.out.println("请输入姓名:>");
        String name = scan.next();


        //构造sql语句, 通过sql语句来描述数据库操作
        // 构造一个插入数据的操作

        //使用？作为占位符
        String sql = "insert into Student values(?, ?)";

        //通过这个对象来表示一个要执行的sql语句， 这个对象的sql也是来自于一个字符串的。
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);
        statement.setString(2, name);

        System.out.println(statement);
        //4.执行sql语句
        int row = statement.executeUpdate();

        System.out.println(row);


        //关闭资源， 后创建的先关闭
        statement.close();
        connection.close();

    }


}
