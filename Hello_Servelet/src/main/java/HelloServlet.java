import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @DATE: 2022/10/9 19:42
 * @PROJECT_NAME: Hello_Servelet
 * @author: 帅哥
 * @DESCRIPTION:
 */

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        这行代码一定要去掉！
//        super.doGet(req, resp);

//        当前需要写一个Hello world！
        resp.getWriter().write("hello world!");

    }


}
