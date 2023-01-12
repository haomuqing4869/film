package com.zxl.entity;

import java.io.Serializable;

/**
 * (TUserinfo)实体类
 *
 * @author makejava
 * @since 2021-10-05 10:25:47
 */
public class TUserinfo implements Serializable {
    private static final long serialVersionUID = 590560556651666747L;
    /**
     * user_name
     */
    private String userName;

    private String password;

    private String userphoto;

    private String usertype;

    private String usertypeStr;
    /**
     * 注册时间
     */
    private String regtime;

    public String getUsertypeStr() {
        if (this.usertype.equals("ROLE_ADMIN")){
            usertypeStr="管理员";
        }else if (this.usertype.equals("ROLE_USER")){
            usertypeStr="普通用户";
        }
        return usertypeStr;
    }

    public void setUsertypeStr(String usertypeStr) {
        this.usertypeStr = usertypeStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "TUserinfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userphoto='" + userphoto + '\'' +
                ", usertype='" + usertype + '\'' +
                ", regtime='" + regtime + '\'' +
                '}';
    }
}