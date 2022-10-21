package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @DATE: 2022/10/20 0:36
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION: 这个类用来对Blog表进行数据的操作。
 * 1.增加博客(博客编辑页)
 * 2.查询出博客列表(博客列表页)
 * 3.查询出博客详情（博客详情页）
 * 4.删除博客（博客详情页加入）
 */
public class BlogDao {

    //新增一篇博客
    //此处的Blog是前端提交给后端的。
    public void insert(Blog blog){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.建立连接
            connection = DBUtil.getConnection();

            //2. 构造sql语句
            String str = "insert into blog values(null, ?, ?, ?, now())";
            statement = connection.prepareStatement(str);
            //这里计算的是第几个问号
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());
            
            
            //3.执行sql语句
            int n = statement.executeUpdate();

            if (n != 1){
                System.out.println("插入失败");
            } else {
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, null);
        }

    }

    //这里要注意的是， 我们这里是博客列表页， 无需将所有内容展示出来， 因此， 只需要截取一小部分
    public List<Blog> selectAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Blog> blogs = new ArrayList<>();
        try {
            //1.获取连接
            connection = DBUtil.getConnection();

            //2.构造sql语句
            String sql = "select * from blog";
            statement = connection.prepareStatement(sql);

            //3.执行sql语句
            resultSet = statement.executeQuery();

            //4.遍历结果集合
            while (resultSet.next()){

                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));

                String content = resultSet.getString("content");
                if (content.length() > 100){
                    content = content.substring(0, 100);
                }

                blog.setContent(content);

                blog.setUserId(resultSet.getInt("userID"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return blogs;

    }

    public Blog selectOne(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Blog blog = null;
        try {
            //1.获取连接
            connection = DBUtil.getConnection();

            //2.构造sql语句。
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);

            //3.执行sql语句。
            ResultSet set = statement.executeQuery();

            //4.创建一个新的对象
            if (set.next()){
                blog = new Blog();

                blog.setBlogId(set.getInt("blogId"));
                blog.setTitle(set.getString("title"));
                blog.setContent(set.getString("content"));
                blog.setUserId(set.getInt("userId"));

                blog.setPostTime(set.getTimestamp("postTime"));
                return blog;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            DBUtil.close(connection, statement, resultSet);

        }
        return null;
    }

    public void delete(int blogId){

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtil.getConnection();

            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            int n = statement.executeUpdate();
            if (n == 1){
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {
            DBUtil.close(connection, statement, null);
        }


    }


}
