import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @DATE: 2022/10/9 23:21
 * @PROJECT_NAME: servlet
 * @DESCRIPTION:
 */
@WebServlet("/love")

public class HelloServlet extends HttpServlet {


    public HelloServlet() {
        System.out.println("构造方法执行了");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello java");
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("你好，doGet");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("doPost");

        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("你好, doPost");


    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doPut");


        resp.setContentType("text/html; charset=utf8");

        resp.getWriter().write("你好， doPut");

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("doDelete");

        resp.setContentType("text/html; charset=utf8");

        resp.getWriter().write("你好， doDelete");

    }
}

