package com.example.administrator.myappcompatactivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 右滑删除基类activity
 * Created by Administrator on 2016/4/11.
 */
public abstract class BaseSwipeActivity extends SwipeActivity{
    protected Activity context = this;
    protected LinearLayout iv_back ;//返回
    protected TextView tv_head_title;//标题
    protected   	TextView        tv_help;//帮助
    protected ImageView iv_confirm_update   ;//对勾


    /**
     * 主线程Handler
     */
    protected Handler handler = new Handler();


    protected ProgressDialog progressDialog;

    public BaseSwipeActivity() {
        context = this;
    }


    @Override
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);

        initView();
    }

    /**
     *
     */
    private void initView() {
        loadViewLayout();
        findViewById();
        setListener();
        processLogic();
    }

    //初始化 头部
    public void findHeadrId(){
        iv_back    = (LinearLayout) findViewById(R.id.iv_back);
        tv_head_title    = (TextView) findViewById(R.id.tv_head_title);
        tv_help    = (TextView) findViewById(R.id.tv_help);
        iv_confirm_update    = (ImageView) findViewById(R.id.iv_confirm_update);
        iv_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    /**
     * 加载布局
     */
    protected abstract void loadViewLayout();

    /**
     * 查找组件
     */
    protected abstract void findViewById();

    /**
     * 向后台请求数据
     */
    protected abstract void processLogic();

    /**
     * 设置监听
     */
    protected abstract void setListener();
}
