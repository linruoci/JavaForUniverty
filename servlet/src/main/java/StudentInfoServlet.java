import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @DATE: 2022/10/13 18:15
 * @PROJECT_NAME: servlet
 * @author: 帅哥
 * @DESCRIPTION:
 */



class Student{

    public int classid;
    public int studentId;

    public int className;
}

@WebServlet("/studentInfo")
public class StudentInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html; charset=utf8");
        String queryString = req.getQueryString();


        String classId = req.getParameter("classId");

        String studentId = req.getParameter("studentId");

        System.out.println("classId:" + classId + "studentId:" + studentId);
        resp.getWriter().println("classId:" + classId + "studentId:" + studentId);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //在这里处理body为application/x-www.urlencoded的代码
//
//        String classId = req.getParameter("classId");
//
//        String studentId = req.getParameter("studentId");
//
//        System.out.println("classId: " + classId + " "+ "studentId: " + studentId);
//
//        resp.getWriter().println("classId: " + classId + " "+ "studentId: " + studentId);


        //在这里处理JSON格式的请求

        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(req.getInputStream(), Student.class);

        System.out.println(student.classid + " " + student.studentId);
        resp.getWriter().write(student.classid + " " + student.studentId);

    }
}