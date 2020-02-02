package com.example.newapaper.model.getNews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;

import com.example.newapaper.R;
import com.example.newapaper.model.NewsList;
import com.example.newapaper.model.NewsType;
import com.example.newapaper.model.apiService;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class getNewsFromServer implements getNewsModel {

    Context context;

    public getNewsFromServer(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    com.example.newapaper.model.apiService apiService;


    public getNewsFromServer() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(apiService.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService=retrofit.create(com.example.newapaper.model.apiService.class);

    }

    @Override
    public Single<NewsList> getNewsType(NewsType newsType) {
        Single<NewsList>  newsListSingle = apiService.getTop();
        if (newsType.equals(NewsType.topNews)) {
            newsListSingle = apiService.getTop();
        }
        else {
            newsListSingle = apiService.getIssu(newsType.toString());

        }


        return newsListSingle;

    }

    @Override
    public Observable<Bitmap> getImage(final String Url) {
        final Bitmap bitmapp;


        return  Observable.create(new ObservableOnSubscribe<Bitmap>() {
            @Override
            public void subscribe(final ObservableEmitter<Bitmap> emitter) throws Exception {
            Picasso.get().load(Url).into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });
            }
        });


}
}