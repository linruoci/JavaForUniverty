package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.io.IOException;

/**
 * @DATE: 2022/10/18 13:18
 * @PROJECT_NAME: servlet
 * @author: 帅哥
 * @DESCRIPTION:
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置我们的body格式。
        resp.setContentType("text/html; charset=utf8");

        //获取到我们的用户名和密码。
        String username = req.getParameter("username");
        String password = req.getParameter("password");



        if (username == null || username.equals("") || password == null || password == ""){

            resp.getWriter().write("账号或密码不能为空");
            return;

        }

        //判断我们的数据库里边是否有数据，这里我们使用if语句来进行判断。
        //判断失败的情况下
        if (!username.equals("zhangsan") || !password.equals("1234")){

            resp.getWriter().write("账号或密码错误!");
            return;
        }


        //这里是判断成功登录的情况下， 如果用户第一次登录， 则会在tomcat内部维护的哈希表里新增一个SessionID为key： HttpSession为value. 同时会把我们的sessionID作为set-cookie的参数发给我们的浏览器
        HttpSession session = req.getSession(true);

        //设置键值对。
        session.setAttribute("username", "zhangsan");
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null){

            session.setAttribute("visitCount", 0);

        } else {

        }



        //跳转到主界面
        resp.sendRedirect("index");

    }
}
