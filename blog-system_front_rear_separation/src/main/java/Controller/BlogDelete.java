package Controller;

import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @DATE: 2022/10/23 16:58
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION:
 */
@WebServlet("/blogDelete")
public class BlogDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //这里要注意一点， 需要进行用户是否登录的判定。
        HttpSession session = req.getSession();

        if (session == null){
            resp.setStatus(403);
            return;
        }
        User user = (User) session.getAttribute("user");

        if (user == null){
            resp.setStatus(403);
            return;
        }

        String blogId = req.getParameter("blogId");
        if (blogId == null || "".equals(blogId)){
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("要删除的文章不存在");
            return;
        }
        BlogDao blogDao = new BlogDao();

        blogDao.delete(Integer.parseInt(blogId));

        resp.sendRedirect("html/blog-list.html");

    }
}
