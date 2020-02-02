package com.example.newapaper.model;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiService {

    final String BaseUrl= "https://newsapi.org";
    final String API_KEY= "ef896aec94d1430f92182deb664b488b";


    @GET("/v2/sources?language=en&country=us&apiKey="+API_KEY)
    Single<NewsAgencyList> getSource();



    @GET("/v2/top-headlines?country=us&apiKey="+API_KEY)
    Single<NewsList> getTop();


    @GET("/v2/top-headlines?country=us&apiKey="+API_KEY)
    Single<NewsList> getIssu(@Query("category") String s);

    @GET("/v2/everything?apiKey="+API_KEY)
    Single<NewsList>getSearchNEs(@Query("q") String keyWord);

}

