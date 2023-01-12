package com.zxl.filter;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.HttpPutFormContentFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CaptchaFilter extends HttpPutFormContentFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 判断session当中的验证码 与 用户输入的验证码是否一致
        // 如果不加判断，它会过滤全部的请求
        String uri = request.getRequestURI();

        if (uri.contains("/login")) {
            String sessionCode = (String) request.getSession().getAttribute("captcha");

            String userCode = request.getParameter("captcha");

            if (StringUtils.isEmpty(userCode)) {
                response.sendRedirect("login.jsp");
                return;
            }

            if (!sessionCode.equalsIgnoreCase(userCode)) {
                response.sendRedirect("login.jsp");
                return;
            }
        }
        super.doFilterInternal(request, response, filterChain);
    }
}
