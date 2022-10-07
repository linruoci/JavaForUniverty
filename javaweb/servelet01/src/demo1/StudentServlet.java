package demo1;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @PROJECT_NAME: javaweb
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/6 12:40
 */
public class StudentServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;
        try {
            //获取驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
