package com.nsu.fit.newsapp.network;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import lombok.Getter;

@Getter
public class NewsDataSourceFactory extends DataSource.Factory<Integer, News> {
    private MutableLiveData<NewsDataSource> newsDataSourceData;

    @NonNull
    @Override
    public DataSource<Integer, News> create() {
        NewsDataSource newsDataSource = new NewsDataSource();
        newsDataSourceData = new MutableLiveData<>();
        newsDataSourceData.postValue(newsDataSource);
        return newsDataSource;
    }
}
