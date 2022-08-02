package com.yujian.financial_client.utils;

/**
 * 通用返回对象
 *
 */
public class CommonResult<T> {
    private long code;
    private String msg;
    private int count;
    private T data;

 
    protected CommonResult() {
    }
 
    protected CommonResult(long code, String msg, int count ,T data) {

        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
 
    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(int count,T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),count, data);
    }
 
    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  msg 提示信息
     */
    public static <T> CommonResult<T> success(int count,T data, String msg) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), msg,count, data);
    }
 
    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), 0,null);
    }
 
    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param msg 错误信息
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode,String msg) {
        return new CommonResult<T>(errorCode.getCode(), msg,0 ,null);
    }
 
    /**
     * 失败返回结果
     * @param msg 提示信息
     */
    public static <T> CommonResult<T> failed(String msg) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), msg, 0,null);
    }
 
    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }
 
    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }
 
    /**
     * 参数验证失败返回结果
     * @param msg 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String msg) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), msg,0, null);
    }
 
    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(),0 ,data);
    }
 
    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(),0 ,data);
    }
 
    public long getCode() {
        return code;
    }
 
    public void setCode(long code) {
        this.code = code;
    }
 
    public String getmsg() {
        return msg;
    }
 
    public void setmsg(String msg) {
        this.msg = msg;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public  int getCount(){

        return count;
    }

    public T getData() {
        return data;
    }
 
    public void setData(T data) {
        this.data = data;
    }
}