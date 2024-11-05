package schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import schedule.pojo.SysUser;

import java.io.IOException;

@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获得session域对象
        HttpSession session = request.getSession();
        Object sysUser = (SysUser)session.getAttribute("sysUser");

        //判断用户是否为空
        //空则重定向
        //登录则放行
        if (sysUser == null) {
            response.sendRedirect("/login.html");
        } else {
            filterChain.doFilter(request,response);
        }

    }
}
