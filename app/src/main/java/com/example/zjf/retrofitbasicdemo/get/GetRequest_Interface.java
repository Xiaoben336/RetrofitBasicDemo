package com.example.zjf.retrofitbasicdemo.get;

import retrofit2.Call;
import retrofit2.http.GET;

/**
*@description 用于描述网络请求 的接口
 *                  采用 注解 描述 网络请求参数
 *
*
*@author zjf
*@date 2018/10/23 16:14
*/
public interface GetRequest_Interface {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();
}
