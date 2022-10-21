package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @DATE: 2022/10/20 0:36
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION:
 * 1.根据用户名来查询用户信息(主要是看用户名和密码是否匹配)
 * 2.根据用户的id来查询用户信息（获取文章的时候， 根据博客的userId拿到作者的信息）
 */

public class UserDao {

    public User selectByName(String userName){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();

            String sql = "select * from user where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);

            resultSet = statement.executeQuery();

            if (resultSet.next()){

                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;

    }

    public User selectById(int userId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();

            String sql = "select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            resultSet = statement.executeQuery();

            if (resultSet.next()){

                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;

    }


}
