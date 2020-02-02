package com.example.newapaper.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract  class baseFragment extends Fragment implements  baseeView {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=null;
        if (view == null) {
            view=inflater.inflate(getLayout(),container,false);
            ButterKnife.bind(getMeContext(),view);
            Log.i("tttaaa", "onCreateView: in base fragment ");

        }

        return view;
    }


    protected  abstract int  getLayout();



}
