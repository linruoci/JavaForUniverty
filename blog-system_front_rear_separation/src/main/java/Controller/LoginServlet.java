package Controller;

import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @DATE: 2022/10/21 14:27
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION:
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里是为了告知servlet通过utf8的编码去解析我们的请求报文， 虽然我们指定了请求里的格式为utf8， 但是我们的servlet并不知道
        //因此就按照默认的编码格式去编码。
        req.setCharacterEncoding("utf8");
        UserDao userDao = new UserDao();

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        if (username == null || username.equals("") || password == null || password.equals("")){

            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或者密码为空");
            return;
        }

        System.out.println("username:" + username);
        System.out.println("password:" + password);

        User user = userDao.selectByName(username);

        if (user == null){
            //告知浏览器用什么格式来进行解析
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或者密码错误");
            return;
        }

        if (!user.getPassword().equals(password)){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("用户名或者密码错误");
            return;
        }
        //到这里登录成功之后， 我们构造会话。
        HttpSession session = req.getSession(true);
        //把我们的user对象存起来
        session.setAttribute("user", user);

        resp.sendRedirect("html/blog-list.html");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null){

            resp.setStatus(403);
            return;
        }

        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.setStatus(403);
            return;
        }
        resp.setStatus(200);

    }
}
