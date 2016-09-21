package com.example.administrator.myappcompatactivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseSwipeActivity {

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findViewById() {
        findHeadrId();
        Button main = (Button)findViewById(R.id.main);
        TextView textview = (TextView) findViewById(R.id.maintext);
        textview.setClickable(true);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
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
