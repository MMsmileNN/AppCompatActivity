package com.example.administrator.myappcompatactivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/11.
 */
public class ThreeActivity extends BaseSwipeActivity {

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_three);
    }

    @Override
    protected void findViewById() {
        findHeadrId();
        Button main = (Button)findViewById(R.id.three);
        TextView textview = (TextView) findViewById(R.id.maintext);
        textview.setClickable(true);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThreeActivity.this,MainActivity.class);
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
