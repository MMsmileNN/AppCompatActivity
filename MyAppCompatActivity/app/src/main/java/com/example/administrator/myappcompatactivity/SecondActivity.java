package com.example.administrator.myappcompatactivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/11.
 */
public class SecondActivity extends BaseSwipeActivity {

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void findViewById() {
        findHeadrId();
        Button main = (Button)findViewById(R.id.second);
        TextView textview = (TextView) findViewById(R.id.maintext);
        textview.setClickable(true);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {

    }

}
