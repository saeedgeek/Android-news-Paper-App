package com.example.newapaper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.newapaper.base.baseActivity;

public class MainActivity extends baseActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public Context getMeContext() {
        return MainActivity.this;
    }
}
