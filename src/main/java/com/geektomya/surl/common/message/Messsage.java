package com.geektomya.surl.common.message;

/**
 * @author yaoqiuhong
 */
public class Messsage {
    /**
     * 服务器错误
     */
    public static final String SERVER_ERROR="服务器错误";
    /**
     * 当短url没有对应的长url的时候跳转到该地址
     */
    public static final String INDEX = "https://zhqy.xyz";
    /**
     * 当查询短url的时候无对应的长url，返回该信息
     */
    public static final String NO_SHORTURL_TO_REALURL="没有对应的长URL";
    /**
     * 返回的短URL的前缀
     */
    public static final String PERURL="https://surl.zhqy.xyz/";
    /**
     * 返回js中的调用url的前缀
     */
    public static final String PERINJS="https://surl.zhqy.xyz/url/";
    /**
     * 操作成功
     */
   public static final String SUCCESS="操作成功";
}
