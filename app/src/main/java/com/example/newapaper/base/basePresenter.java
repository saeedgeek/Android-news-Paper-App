package com.example.newapaper.base;

public interface basePresenter<T extends baseeView> {
    public void attachView(T view);
    public void detachView();
}
