package com.example.jjdemo;

import android.app.Application;

import com.ccj.client.android.analytics.JJEventManager;
import com.ccj.client.android.analytics.intercept.CookieFacade;

/**
 * @author 张本志
 * @date 2019-07-26 13:42
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initJJ();
    }

    private void initJJ() {
        JJEventManager.init(this, "cookie String", true);

        JJEventManager.Builder builder = new JJEventManager.Builder(this); //方式2
        builder.setPushUrl("这里是请求的接口")//TODO 必填!!!!!!
                .setHostCookie("s test=cookie String;")//cookie(只会初始化调用一次,后续上传不会再调用)
                .setDebug(true)//是否是debug
                .setSidPeriodMinutes(15)//sid改变周期
                .setPushLimitMinutes(1)//多少分钟 push一次
                .setPushLimitNum(100)//多少条 就主动进行push
                .setCookieIntercept(new CookieFacade() {
                    @Override
                    public String getRequestCookies() { //宿主cookie通用参数 动态插入器(每次上传都会执行该方法)
                        return "cookie-->";
                    }
                })
                .start();//开始*/
    }
}
