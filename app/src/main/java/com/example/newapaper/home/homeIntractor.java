package com.example.newapaper.home;

import android.graphics.Bitmap;

import com.example.newapaper.base.baseeView;
import com.example.newapaper.base.basePresenter;
import com.example.newapaper.model.News;
import com.example.newapaper.model.NewsType;

public interface homeIntractor {

    public interface homeView extends baseeView {
        public void showNews(News[] news, NewsType newsType, Bitmap bitmap);

    }

    public interface homePresenter extends basePresenter<homeView> {

    public void getNews();
    }

}
