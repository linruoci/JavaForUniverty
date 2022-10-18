package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @DATE: 2022/10/18 10:16
 * @PROJECT_NAME: servlet
 * @author: 帅哥
 * @DESCRIPTION:
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    //在这里展示用户的个人信息

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到我们的Seesion对象
        HttpSession session = req.getSession(false);

        if (session == null){

            resp.sendRedirect("login.html");
            return;
        }

        String username = (String) session.getAttribute("username");

        Integer visitCount = (Integer) session.getAttribute("visitCount");

        visitCount = visitCount + 1;
        session.setAttribute("visitCount", visitCount);

        resp.setContentType("text/html; charset=utf8");

        resp.getWriter().write("当前用户为:>" + username + "当前访问次数为:>" + visitCount);

    }
}
