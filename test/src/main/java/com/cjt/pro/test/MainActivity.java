package com.cjt.pro.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cjt.pro.logmanager.CLog;
import com.cjt.pro.logmanager.LogService;
import com.cjt.pro.logmanager.entity.LogItem;
import com.cjt.pro.logmanager.window.FxService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text:
                CLog.d("haha", "12345");
                break;
            case R.id.button:
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, FxService.class);
                //启动FxService
                startService(intent);
                finish();
//                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;
            default:
                break;
        }
    }
}
