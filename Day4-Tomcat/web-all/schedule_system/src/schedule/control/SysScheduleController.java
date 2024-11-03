package schedule.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 增加请求 /schedule/add
 * 查询请求 /schedule/query
 * 修改请求 /schedule/update
 * 删除请求 /schedule/delete
 */

@WebServlet("/schedule/*")
public class SysScheduleController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String name = split[split.length - 1];
        if (name.equals("add")) {
            //增加处理
            add(req,resp);
        } else if (name.equals("find")) {
            //查询处理
            find(req, resp);
        } else if (name.equals("update")) {
            //修改处理
            update(req, resp);
        } else if (name.equals("remove")) {
            //删除处理
            delete(req, resp);
        }
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");;
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("find");;

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");;

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");;

    }
}
