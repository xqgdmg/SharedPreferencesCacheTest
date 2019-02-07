package com.example.thinkpad.sharedpreferencescachetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferencesUtil spUtil;
    private TextView tvAddValue;
    private TextView tvRemoveValue;
    private TextView tvShowValue;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spUtil = new SharedPreferencesUtil(getApplicationContext()); // 会不会是这个context中有缓存，好像不是

        initView();
        initListener();

    }

    private void initView() {
        tvAddValue = (TextView) findViewById(R.id.tvAddValue);
        tvRemoveValue = (TextView) findViewById(R.id.tvRemoveValue);
        tvShowValue = (TextView) findViewById(R.id.tvShowValue);
    }

    private void initListener() {

        // 添加新的值
        tvAddValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spUtil.setSharedString("chris","count"+ count++);
                tvShowValue.setText("当前sp的值（点击刷新）== " + spUtil.getSharedString("chris"));
            }
        });

        // 删除旧的值
        tvRemoveValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spUtil.removeSharedKey("chris");
                tvShowValue.setText("当前sp的值（点击刷新）== " + spUtil.getSharedString("chris"));
                count = 0;// 重置count
            }
        });

        // 显示当前的sp值
        tvShowValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvShowValue.setText("当前sp的值（点击刷新）== " + spUtil.getSharedString("chris"));
            }
        });

    }

}
