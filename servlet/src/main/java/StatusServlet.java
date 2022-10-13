import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @DATE: 2022/10/13 21:39
 * @PROJECT_NAME: servlet
 * @author: 帅哥
 * @DESCRIPTION:1
 */

@WebServlet("/status")
public class StatusServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(404);

    }
}
