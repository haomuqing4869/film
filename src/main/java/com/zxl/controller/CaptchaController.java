package com.zxl.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class CaptchaController {
    @RequestMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        //定义图形验证码大小
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 50);
        ByteArrayInputStream imageStream = new ByteArrayInputStream(lineCaptcha.getImageBytes());
        HttpSession session = request.getSession();
        session.setAttribute("captcha", lineCaptcha.getCode());
        ServletOutputStream outputStream = response.getOutputStream();
        lineCaptcha.write(outputStream);
    }
}
