package com.nsu.fit.newsapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.nsu.fit.newsapp.network.News;
import com.nsu.fit.newsapp.network.NewsDataSourceFactory;

import lombok.Getter;

@Getter
public class NewsViewModel extends ViewModel {
    private static final int PAGE_SIZE = 10;
    private LiveData<PagedList<News>> newsLiveData;

    public NewsViewModel() {
        NewsDataSourceFactory newsDataSourceFactory = new NewsDataSourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setInitialLoadSizeHint(PAGE_SIZE * 2)
                .build();
        newsLiveData = new LivePagedListBuilder<>(newsDataSourceFactory, config)
                .build();
    }
}
