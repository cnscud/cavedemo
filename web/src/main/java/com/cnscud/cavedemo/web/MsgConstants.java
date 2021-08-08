package com.cnscud.cavedemo.web;

/**
 * Constants.
 *
 * @author Felix Zhang 2021-08-07 16:17
 * @version 1.0.0
 */
public class MsgConstants {

    public static String saltPrefix = "akfkswiriw2925sdmmsd";

    public static final int EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;

    public static String Cookie_LoginToken = "z";
    public static String Cookie_Domain = ".cnscud.com";
    public static String Cookie_Path = "/";
    public static String Token_Level = "default";


    public static String CURRENT_USER_ATTRIBUTE = "login_user";
    /** 当前登录用户uid在attribute中的属性名称 */
    public static String CURRENT_XID_ATTRIBUTE = "login_xid";

    public static final String CODE_KEY = "code";
    public static final String MSG_KEY = "msg";
    public static final String DATA_KEY = "data";

    //全局部分
    public static int  SUCCESS=0;
    public static int  NEED_LOGIN=900; //需要登录
    public static int FAIL=999;//失败

}
