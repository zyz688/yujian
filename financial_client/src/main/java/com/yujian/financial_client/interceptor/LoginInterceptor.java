package com.yujian.financial_client.interceptor;

import lombok.Lombok;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ze
 * @create 2022-06-29-10:51
 */

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("拦截路径为"+uri);

        //登入检查逻
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        if (loginUser!=null){
            //放行操作
            return  true;
        }
        //拦截住 。检测还没登入 转到登入界面
        request.setAttribute("msg", "还没登入!，请先登入");
        request.getRequestDispatcher("/").forward(request, response);//跳转到登入界面

        return  false;
    }
}
