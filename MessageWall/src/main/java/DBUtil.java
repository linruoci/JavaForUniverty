import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @DATE: 2022/10/16 23:26
 * @PROJECT_NAME: MessageWall
 * @author: 帅哥
 * @DESCRIPTION:
 */

//这个类用来建立与数据库的连接， 同时这里使用单例模式。
public class DBUtil{

    private static DataSource instance = null;


    private static DataSource getInstance(){

        if (instance == null){

            instance = new MysqlDataSource();
            ((MysqlDataSource) instance).setUrl("jdbc:mysql://127.0.0.1:3306/messagewall?characterEncoding=utf8&useSSL=false");
            ((MysqlDataSource) instance).setUser("root");
            ((MysqlDataSource) instance).setPassword("qwe00321..");

        }
        return instance;

    }


    public static Connection getConnection() throws SQLException {

        return getInstance().getConnection();

    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet set){

        if (set != null){
            try {
                set.close();
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
