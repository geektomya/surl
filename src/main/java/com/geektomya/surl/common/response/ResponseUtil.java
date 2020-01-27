package com.geektomya.surl.common.response;

public class ResponseUtil {

    public static enum ResponseStatus{
        // 成功用1表示
        Success(1),
        // 失败用0表示
        Fail(0);

        ResponseStatus(int code){
            this.code = code;
        }

        private int code;

        public int getCode(){
            return code;
        }
    }

    /**
     * 创建响应map的工具方法
     * @param code：响应代码：1标识成功，0标识失败
     * @param msg：如果失败后将返回错误信息
     * @param data：需要响应的数据
     * @return ：
     */
    public static <T> ResponseVo toResponseVo(int code,String msg,T data){

        ResponseVo<Object> responseVo = new ResponseVo<>();

        responseVo.setCode(code);
        responseVo.setMsg(msg);
        responseVo.setData(data);

        return responseVo;
    }

    public static <T> ResponseVo toSuccessResponseVo(T data){

        ResponseVo<Object> responseVo = new ResponseVo<>();

        responseVo.setCode(ResponseStatus.Success.getCode());
        responseVo.setMsg(null);
        responseVo.setData(data);

        return responseVo;
    }

    public static <T> ResponseVo toSuccessResponseVoWithNoData(){

        return toSuccessResponseVo(null);
    }

    public static <T> ResponseVo toFailResponseVo(String msg){

        ResponseVo<Object> responseVo = new ResponseVo<>();

        responseVo.setCode(ResponseStatus.Fail.getCode());
        responseVo.setMsg(msg);
        responseVo.setData(null);

        return responseVo;
    }

    public static <T> ResponseVo toFailResponseVoWithNoMessage(){

        return toFailResponseVo(null);
    }

    public  static String tojs(String msg){
        return msg;
    }
}

