package com.zxl.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCPassward {
    public static String  setPassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        return encode;
    }

    public static void main(String[] args) {
        String s = BCPassward.setPassword("123456");
        System.out.println(s);
    }

}
