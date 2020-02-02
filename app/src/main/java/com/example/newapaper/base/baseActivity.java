package com.example.newapaper.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class baseActivity extends AppCompatActivity implements  baseeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());


    }


    protected abstract   int getLayout();
}
