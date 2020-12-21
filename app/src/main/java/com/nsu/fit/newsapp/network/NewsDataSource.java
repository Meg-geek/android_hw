package com.nsu.fit.newsapp.network;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDataSource extends PageKeyedDataSource<Integer, News> {
    private NewsApi newsApi;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params,
                            @NonNull final LoadInitialCallback<Integer, News> callback) {
        newsApi = NetworkService.getInstance().getNewsApi();
        Call<NewsResponse> responseCall = newsApi.getNews(1, params.requestedLoadSize);
        responseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse newsResponse = response.body();
                if (newsResponse != null) {
                    callback.onResult(newsResponse.getNews(), 1, 2);
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("NetworkError", "Error while loading news, loadInitial()");
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params,
                           @NonNull LoadCallback<Integer, News> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params,
                          @NonNull final LoadCallback<Integer, News> callback) {
        Call<NewsResponse> responseCall = newsApi.getNews(params.key, params.requestedLoadSize);
        responseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse newsResponse = response.body();
                if (newsResponse != null) {
                    callback.onResult(newsResponse.getNews(), params.key + 1);
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("NetworkError", "Error while loading news, loadAfter()");
            }
        });
    }
}
