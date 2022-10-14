import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @DATE: 2022/10/13 23:50
 * @PROJECT_NAME: servlet
 * @author: 帅哥
 * @DESCRIPTION:
 */
@WebServlet("/redirect")
public class Redirect extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("https://sogou.com");
    }

}
