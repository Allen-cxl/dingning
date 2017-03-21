package com.dingning.card.model;


/**
 * Created by Allen on 2016/12/13.
 */

public class BaseResponse<T>{

    public static final int CODE_SUCCESS = 0;  //处理成功
    public static final int CODE_FAIL = -1;  //系统繁忙，稍后再试

    public int status;
    public T data;
    public String info;
}
