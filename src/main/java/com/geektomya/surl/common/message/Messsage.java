package com.geektomya.surl.common.message;

public class Messsage {
    /*
    * 服务器错误
    * */
    public static final String SERVER_ERROR="服务器错误";
    /*
    * 当短url没有对应的长url的时候跳转到该地址
    * */
    public static final String INDEX = "http://zhqy.xyz";
    /*
    * 当查询短url的时候无对应的长url，返回该信息
    * */
    public static final String NO_SHORTURL_TO_REALURL="没有对应的长URL";
    /*
    * 返回的短URL的前缀
    * */
    public static final String PERURL="http://localhost:8087/surl/";

}
