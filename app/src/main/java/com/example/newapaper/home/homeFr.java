package com.example.newapaper.home;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.newapaper.MainActivity;
import com.example.newapaper.R;
import com.example.newapaper.base.baseFragment;
import com.example.newapaper.model.News;
import com.example.newapaper.model.NewsType;
import com.example.newapaper.model.getNews.getNewsRepository;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class homeFr extends baseFragment implements homeIntractor.homeView{

    @BindView(R.id.Top_news)
    ImageView topNews;


    @BindView(R.id.business)
    ImageView business;


    @BindView(R.id.entertainment)
    ImageView entertainment;


    @BindView(R.id.health)
    ImageView health;


    @BindView(R.id.technology)
    ImageView technology;

    @BindView(R.id.science)
    ImageView science;


    @BindView(R.id.Sport)
    ImageView Sport;

    @BindView(R.id.General)
    ImageView general;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.ViewPager)
    ViewPager viewPager;

    @BindView(R.id.prbusiness)
    ProgressBar prbusiness;


    @BindView(R.id.prTop_news)
    ProgressBar prTop_news;


    @BindView(R.id.prentertainment)
    ProgressBar prentertainment;


    @BindView(R.id.prhealth)
    ProgressBar prhealth;


    @BindView(R.id.prtechnology)
    ProgressBar prtechnology;


    @BindView(R.id.prscience)
    ProgressBar prscience;


    @BindView(R.id.prSport)
    ProgressBar prSport;


    @BindView(R.id.prGeneral)
    ProgressBar prGeneral;

    homeIntractor.homePresenter presenter;

    public homeFr() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new homePresenter(new getNewsRepository(getContext()));
        presenter.attachView(this);
        presenter.getNews();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public Context getMeContext() {
        return getContext();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showNews(News[] news, NewsType newsType, Bitmap bitmap) {
        if (newsType.equals(NewsType.general)){


        }
        else if (newsType.equals(NewsType.sports)){

        }
        else if (newsType.equals(NewsType.health)){

        }
        else if (newsType.equals(NewsType.topNews)){}
        else if (newsType.equals(NewsType.entertainment)){}
        else if (newsType.equals(NewsType.business)){}
        else if (newsType.equals(NewsType.science)){}
        else if (newsType.equals(NewsType.technology)){ }
}

}
