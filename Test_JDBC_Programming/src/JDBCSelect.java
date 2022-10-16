import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @DATE: 2022/10/16 14:29
 * @PROJECT_NAME: Test_JDBC_Programming
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class JDBCSelect {

    public static void main(String[] args) throws SQLException {


        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java104?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("qwe00321..");


        Connection connection = dataSource.getConnection();

        String sql = "select * from student";


        PreparedStatement statement = connection.prepareStatement(sql);


        //执行查找

        ResultSet set = statement.executeQuery();

        while (set.next()){

            //取id, 参数写列的名字
            int id = set.getInt("id");

            //取name
            String name = set.getString("name");


            System.out.println(id + " " + name);

        }

        //关闭资源
        statement.close();
        connection.close();

    }

}
