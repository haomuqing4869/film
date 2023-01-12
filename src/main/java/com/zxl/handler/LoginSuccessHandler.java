package com.zxl.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        RequestCache requestCache = new HttpSessionRequestCache();
        String url = null;
        SavedRequest savedRequest = requestCache.getRequest(httpServletRequest,httpServletResponse);
        if(savedRequest != null){
            url = savedRequest.getRedirectUrl();
            System.out.println("URL:" + url);
        }
        if(url == null){
            httpServletResponse.sendRedirect("index.jsp");
        } else {
            httpServletResponse.sendRedirect(url);
        }
    }
}
