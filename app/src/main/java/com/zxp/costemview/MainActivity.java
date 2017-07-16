package com.zxp.costemview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zxp.bordertextview.MyTextView;

public class MainActivity extends AppCompatActivity {

    MyTextView myTextView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
