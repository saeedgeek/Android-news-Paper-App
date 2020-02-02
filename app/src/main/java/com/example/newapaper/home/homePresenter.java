package com.example.newapaper.home;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.example.newapaper.model.News;
import com.example.newapaper.model.NewsList;
import com.example.newapaper.model.NewsType;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class homePresenter implements homeIntractor.homePresenter {
    com.example.newapaper.model.getNews.getNewsModel getNewsModel;
    homeIntractor.homeView view;

    public homePresenter(com.example.newapaper.model.getNews.getNewsModel getNewsModel) {
        this.getNewsModel = getNewsModel;
    }

    @Override
    public void getNews() {


        getNewsIssu(NewsType.topNews);
        getNewsIssu(NewsType.health);
        getNewsIssu(NewsType.business);
        getNewsIssu(NewsType.entertainment);
        getNewsIssu(NewsType.general);
        getNewsIssu(NewsType.science);
        getNewsIssu(NewsType.sports);
        getNewsIssu(NewsType.technology);



    }

    public  void getNewsIssu(final NewsType newsType){
        getNewsModel.getNewsType(newsType).subscribeOn(Schedulers.newThread()).subscribe(new SingleObserver<NewsList>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(final NewsList newsList) {
            getNewsModel.getImage(newsList.getArticles()[0].getUrlToImage()).subscribeOn(Schedulers.newThread()).subscribe(new Observer<Bitmap>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(Bitmap bitmap) {
                    view.showNews(newsList.getArticles(),newsType,bitmap);
                    Log.i("tagg", "onNext: get bitmap : "+bitmap);
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    @Override
    public void attachView(homeIntractor.homeView view) {
    this.view=view;
        Log.i("tttaaa", "attachView: ");
    }

    @Override
    public void detachView() {
    view=null;
    }
}
