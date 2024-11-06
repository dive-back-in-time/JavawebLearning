package schedule.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import schedule.common.Result;
import schedule.common.ResultCodeEnum;
import schedule.pojo.SysUser;
import schedule.service.SysUserService;
import schedule.service.impl.SysUserServiceImpl;
import schedule.util.MD5Util;
import schedule.util.WebUtil;

import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private SysUserService userService = new SysUserServiceImpl();
    /**
     * 接收用户注册请求的业务处理方法（业务处理接口）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户提交参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        //调用服务层方法，完成注册
        //将参数封装进sysUser对象中
        SysUser user = new SysUser(null,username,userPwd);
        boolean bool = userService.register(user);

        //根据结果完成页面跳转
        if (bool == true) {
            resp.sendRedirect("/registerSuccess.html");
        } else {
            resp.sendRedirect("/registerFall.html");
        }

    }

    /**
     * 完成登录请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户提交参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        //调用服务层方法，根据用户名查询用户信息
        SysUser user = userService.findbyUser(username);

        //判断查询信息与输入信息是否符合
        if (user == null) {
            resp.sendRedirect("/loginUserNameError.html");
        } else if (!user.getUserpwd().equals(MD5Util.encrypt(userPwd) )) {
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            //登录成功后，将用户信息放入session域
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", user);
            resp.sendRedirect("/showSchedule.html");
        }


    }

    /**
     * 注册时接收要注册的用户名，校验用户名是否被占用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户名
        String username = req.getParameter("username");

        //调用服务层处理方法查询是否有对应用户
        SysUser user = userService.findbyUser(username);

        /*
            解决响应格式问题
            要响应一个JSON字符串
         */
        Result result = Result.ok(null);

        //有则响应已占用，没有回复未占用，ok
        if (user == null) {

        } else {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        //转换成json
        WebUtil.writeJson(resp,result);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");

    }
}

