package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @DATE: 2022/10/20 13:49
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION:
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogDao blogDao = new BlogDao();
        String blogId = req.getParameter("blogId");
        resp.setContentType("application/json;charset=utf8");

        if (blogId == null){


            List<Blog> blogList = blogDao.selectAll();

            String data = mapper.writeValueAsString(blogList);


            resp.getWriter().write(data);

        } else {


            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));

            String jsonString = mapper.writeValueAsString(blog);

            resp.getWriter().write(jsonString);


        }



    }


    //这个请求在这里提交一篇博客
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        BlogDao blogDao = new BlogDao();
        Blog blog = new Blog();
        String title = req.getParameter("title");
        String content = req.getParameter("content");

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


        if (title == null || content == null || "".equals(title) || "".equals("content")){
            resp.setStatus(400);
            resp.setContentType("text/html; charset=utf9");
            resp.getWriter().write("请求中的标题或正文为空。");
            return;
        }

        blog.setTitle(title);
        blog.setContent(content);
        blog.setUserId(user.getUserId());

        int blogId = blogDao.insert(blog);
        //插入成功之后， 返回博客列表页
        String str = "html/blog-detail.html?blogId="+blogId;
        resp.sendRedirect(str);


    }
}
