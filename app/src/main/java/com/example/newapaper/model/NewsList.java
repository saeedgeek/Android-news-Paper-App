package com.example.newapaper.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class NewsList implements Parcelable {

    private String status;
    private int totalResults;
    private News[] articles;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }


    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public News[] getArticles() {
        return articles;
    }

    public void setArticles(News[] articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsList{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", articles=" + Arrays.toString(articles) +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeInt(this.totalResults);
        dest.writeTypedArray(this.articles, 0);
    }

    public NewsList() {
    }

    protected NewsList(Parcel in) {
        this.status = in.readString();
        this.totalResults = in.readInt();
        this.articles = in.createTypedArray(News.CREATOR);
    }

    public static final Creator<NewsList> CREATOR = new Creator<NewsList>() {
        @Override
        public NewsList createFromParcel(Parcel source) {
            return new NewsList(source);
        }

        @Override
        public NewsList[] newArray(int size) {
            return new NewsList[size];
        }
    };
}
