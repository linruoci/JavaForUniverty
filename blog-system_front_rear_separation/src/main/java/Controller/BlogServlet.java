package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}
