package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
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
 * @DATE: 2022/10/22 0:39
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION:
 */
@WebServlet("userInfo")
public class UserInfoServlet extends HttpServlet {
    private  ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogId = req.getParameter("blogId");
        //这里如果是null，说明在我们的博客列表页， 此时查找登录用户的个人信息
        if (blogId == null){
            HttpSession session = req.getSession(false);

            if (session == null){
                resp.setContentType("text/html;charset=utf8");
                resp.getWriter().write("当前未登录!");
                return;
            }

            User user = (User) session.getAttribute("user");
            if (user == null){

                resp.setContentType("text/html;charset=utf8");
                resp.getWriter().write("当前未登录!");
                return;
            }
            resp.setContentType("application/json;charset=utf8");
            String s = mapper.writeValueAsString(user);
            resp.getWriter().write(s);

        } else {
            //请求来自博客详情页， 此时返回文章作者信息
            BlogDao blogDao = new BlogDao();

            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));

            if (blog == null){
                resp.setContentType("text/html;charset=utf8");
                resp.getWriter().write("当前博客id有误!");
                return;
            }

            UserDao userDao = new UserDao();
            int userId = blog.getUserId();

            User user = userDao.selectById(userId);

            if (user == null){
                resp.setContentType("text/html;charset=utf8");
                resp.getWriter().write("没找到当前作者!");
                return;
            }

            resp.setContentType("application/json;charset=utf8");
            String s = mapper.writeValueAsString(user);
            resp.getWriter().write(s);

        }

    }
}
