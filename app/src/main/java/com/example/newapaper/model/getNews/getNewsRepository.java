package com.example.newapaper.model.getNews;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.newapaper.model.NewsList;
import com.example.newapaper.model.NewsType;

import io.reactivex.Observable;
import io.reactivex.Single;

public class getNewsRepository implements  getNewsModel {
    Context context;

    public getNewsRepository(Context context) {
        this.context = context;
    }

    getNewsFromServer getNewsFromServer=new getNewsFromServer(context);
    com.example.newapaper.model.getNews.getNewsFromDb getNewsFromDb;



    @Override
    public Single<NewsList> getNewsType(NewsType newsType) {
        return getNewsFromServer.getNewsType(newsType);
    }

    @Override
    public Observable getImage(String Url) {
        return getNewsFromServer.getImage(Url);
    }
}
