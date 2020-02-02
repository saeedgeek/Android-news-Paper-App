package com.example.newapaper.model.getNews;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.newapaper.model.NewsList;
import com.example.newapaper.model.NewsType;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface getNewsModel {
    public Single<NewsList>  getNewsType(NewsType newsType);
    public Observable<Bitmap> getImage(String Url);
}
