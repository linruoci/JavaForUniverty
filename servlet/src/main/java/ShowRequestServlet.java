import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @DATE: 2022/10/11 21:44
 * @PROJECT_NAME: servlet
 * @author: 帅哥
 * @DESCRIPTION:
 */
@WebServlet("/showRequest")
public class ShowRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder buffer = new StringBuilder();

        buffer.append(req.getProtocol());
        buffer.append("<br>");

        buffer.append(req.getMethod());
        buffer.append("<br>");


        buffer.append(req.getRequestURI());
        buffer.append("<br>");

        buffer.append(req.getContextPath());
        buffer.append("<br>");

        buffer.append(req.getQueryString());
        buffer.append("<br>");

        Enumeration<String> headerNames = req.getHeaderNames();


        while (headerNames.hasMoreElements()){

            String name = headerNames.nextElement();

            buffer.append(name + ": " + req.getHeader(name));

            buffer.append("<br>");

        }

        resp.setContentType("text/html; charset = utf8");
        resp.getWriter().write(buffer.toString());

    }

}
