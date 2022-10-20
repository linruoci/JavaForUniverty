package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @DATE: 2022/10/19 23:46
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION: 通过这个类来封装数据库的连接和关闭操作
 */
public class DBUtil {
    //servlet程序是运行在多线程环境中的。 每个请求都有可能对应着一个线程（tomcat是通过多线程的方式来处理很多请求的）
    private volatile static DataSource dataSource = null;


    private static DataSource getDataSource(){

       if (dataSource == null){

           synchronized (DBUtil.class){

               if (dataSource == null){
                   dataSource = new MysqlDataSource();
                   ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/blog_system?characterEncoding=utf8&useSSL=false");
                   ((MysqlDataSource) dataSource).setUser("root");
                   ((MysqlDataSource) dataSource).setPassword("qwe00321..");
               }

           }

       }
        return dataSource;


    }

    public static Connection getConnection() throws SQLException {

        return getDataSource().getConnection();

    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if (resultSet != null){

            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        if (statement != null){

            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        if (connection != null){

            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }






    }


}
