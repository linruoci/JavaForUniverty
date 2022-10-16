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

        //不需要进行任何的解析操作， 直接进行返回即可~

        resp.setContentType("application/json; charset=utf8");

        //将我们存储的数组进行解析得到一个json字符串。
        List<Message> messageList = load();
        String str = mapper.writeValueAsString(messageList);

        //将这个字符串直接返回即可

        resp.getWriter().write(str);

    }



    //负责实现客户端提交数据到浏览器
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //将post请求中的body（json）格式进行读取
        Message message = mapper.readValue(req.getInputStream(), Message.class);


        save(message);


        System.out.println(message);

        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write("{\"ok\":1}");

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
