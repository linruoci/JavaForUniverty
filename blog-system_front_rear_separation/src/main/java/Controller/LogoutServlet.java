package Controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @DATE: 2022/10/23 9:55
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION:
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null){
            resp.setStatus(403);
            System.out.println("当前session不存在");
            return;
        }

        User user = (User) session.getAttribute("user");

        if (user == null){
            resp.setStatus(403);
            System.out.println("session存在，user不存在");
            return;
        }

        //到这里是登录状态， 可以注销。
        req.removeAttribute("user");
        resp.sendRedirect("html/blog-login.html");

    }
}
