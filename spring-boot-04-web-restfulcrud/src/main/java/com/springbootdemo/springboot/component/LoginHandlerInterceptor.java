package com.springbootdemo.springboot.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标执行前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("loginUser");
        /*
        犯的一个错，就是在获取user的时候表达式写错了，写成Object user=request.getAttribute("loginUser");
        根本获取不了session的user，所以全都被拦截了
         */

        if(user==null)
        {
            //未登录

             request.setAttribute("msg","没有权限请先登录");
             request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        else
        {
            //已登录
            return  true;
        }

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
