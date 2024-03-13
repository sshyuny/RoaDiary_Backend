package com.sshyuny.roadiary.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sshyuny.roadiary.common.SessionManager;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PageLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        HttpSession session = request.getSession();
        
        if (!SessionManager.isLoginStatus(session)) {
            String uri = request.getRequestURI();
            response.sendRedirect("/login?redirect=" + uri);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, 
            Exception ex) throws Exception {
        if (ex != null) {
            String uri = request.getRequestURI();
            log.error(uri + "요청 도중 예외 발생", ex);
        }
    }

}
