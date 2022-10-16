import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @DATE: 2022/10/16 14:20
 * @PROJECT_NAME: Test_JDBC_Programming
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class JDBCUpdate {


    public static void main(String[] args) throws SQLException {

        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java104?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("qwe00321..");

        Connection connection = dataSource.getConnection();

        System.out.println("请输入你要修改的同学的学号");
        Scanner scan = new Scanner(System.in);

        int id = scan.nextInt();

        System.out.println("修改为:>");

        String str = scan.next();

        String sql = "update student set name = ? where id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, str);
        statement.setInt(2, id);

        int n = statement.executeUpdate();
        System.out.println(n);


        statement.close();
        connection.close();


    }


}
