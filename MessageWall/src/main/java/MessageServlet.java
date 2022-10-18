import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @DATE: 2022/10/16 20:26
 * @PROJECT_NAME: MessageWall
 * @author: 帅哥
 * @DESCRIPTION:
 */

class Message{

    public String from;
    public String to;
    public String message;



    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}


@WebServlet("/message")
public class MessageServlet extends HttpServlet {

    ObjectMapper mapper = new ObjectMapper();
    //List<Message> messageList = new ArrayList<>();

    //负责实现让客户端从服务器拿到数据

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //由于请求中不带数据， 因此只需要将我们数据库的文件加载到页面上即可

        //调用load方法将我们的数据加载到我们的List对象里
        List<Message> messageList = load();

        String str = mapper.writeValueAsString(messageList);

        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(str);


    }


    //负责实现客户端提交数据到浏览器


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取数据。
        Message message = mapper.readValue(req.getInputStream(), Message.class);

        //这里将我们的json数据读取成一个message对象。将其插入到我们的数据库中。
        save(message);

        //打印日志.
        System.out.println(message);

        //返回一个ok
        resp.getWriter().write("{\"ok\": \"1\"}");




    }

    public void save(Message message){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //第一步， 获取连接。
            connection = DBUtil.getConnection();


            //第二步, 构造sql语句
            String sql = "insert into message values(?, ?, ?)";
            statement = connection.prepareStatement(sql);

            statement.setString(1, message.from);
            statement.setString(2, message.to);
            statement.setString(3, message.message);

            //执行sql语句

            int n = statement.executeUpdate();



        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            //关闭连接
            DBUtil.close(connection, statement, null);


        }

    }


    public List<Message> load(){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Message> messageList = new ArrayList<>();

        try {
            //创建数据库连接
            connection = DBUtil.getConnection();

            //构造sql语句
            String sql = "select * from message";

            //执行sql语句
            statement = connection.prepareStatement(sql);

            //获得ResultSet对象
            set = statement.executeQuery();

            while (set.next()){

                Message message = new Message();

                message.from = set.getString("from");
                message.to = set.getString("to");
                message.message = set.getString("message");

                messageList.add(message);

            }

            return messageList;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {
            DBUtil.close(connection, statement, set);
        }


    }


}
