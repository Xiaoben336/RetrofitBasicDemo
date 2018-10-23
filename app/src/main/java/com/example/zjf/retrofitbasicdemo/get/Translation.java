package com.example.zjf.retrofitbasicdemo.get;
/**
*@description  接收服务器返回数据 的类
*
*@author zjf
*@date 2018/10/23 16:11
*/
public class Translation {
    private int status;
    private Content content;

    private static class Content{
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    public void show(){
        System.out.println(status);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);
    }
}
