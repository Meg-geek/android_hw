package com.nsu.fit.newsapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("everything?apiKey=23e25ed89da049c0a4889e86fb2bd878&q=android&language=ru")
    Call<NewsResponse> getNews(@Query("page") Integer page,
                               @Query("pageSize") Integer pageSize);
}
