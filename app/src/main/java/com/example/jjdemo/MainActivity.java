package com.example.jjdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ccj.client.android.analytics.JJEvent;
import com.ccj.client.android.analytics.JJEventManager;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView tv_show;
    Button btn_event, btn_pv, btn_cancel, btn_push;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_show = findViewById(R.id.tv_show);
        btn_event = findViewById(R.id.btn_event);
        btn_pv = findViewById(R.id.btn_pv);
        btn_push = findViewById(R.id.btn_push);
        btn_cancel = findViewById(R.id.btn_cancel);


        /**
         * 点击事件
         */
        btn_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int k = 0; k < 40; k++) {
                    //添加自定义参数ecp,ecp默认为null
                    Map ecp = new HashMap();
                    ecp.put("自定义key1", "自定义value1");
                    ecp.put("自定义key2", "自定义value2");
                    JJEvent.trackClick("event " + k, "event ea", "event el");
                }
            }
        });

        /**
         * 主动推送
         * */
        btn_pv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加自定义参数ecp,ecp默认为null
                Map ecp = new HashMap();
                ecp.put("自定义key1", "自定义value1");
                ecp.put("自定义key2", "自定义value2");
                JJEvent.trackExpose("ss1", "首页", "点击" + "button" + (++i), ecp);
                JJEventManager.pushEvent();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JJEventManager.destoryEventService();
            }
        });

        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JJEventManager.pushEvent();
                Toast.makeText(MainActivity.this, "saefsdfasdf-->" + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
