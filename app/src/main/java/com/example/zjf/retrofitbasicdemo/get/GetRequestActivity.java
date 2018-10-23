package com.example.zjf.retrofitbasicdemo.get;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zjf.retrofitbasicdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
*@description 步骤1：添加Retrofit库的依赖 --- build.gradle
                步骤2：创建 接收服务器返回数据 的类 --- Translation.java
                步骤3：创建 用于描述网络请求 的接口 --- GetRequest_Interface
                步骤4：创建 Retrofit 实例
                步骤5：创建 网络请求接口实例 并 配置网络请求参数
                步骤6：发送网络请求（采用最常用的异步方式）
                    封装了 数据转换、线程切换的操作
                步骤7： 处理服务器返回的数据

*
*@author zjf
*@date 2018/10/23 15:54
*/
public class GetRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request();
    }

    private void request() {
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")// 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);
        //对 发送请求 进行封装
        Call<Translation> call = request.getCall();
        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                //请求成功时回调
                response.body().show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                System.out.println("连接失败");
            }
        });
    }
}
