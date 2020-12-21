package com.nsu.fit.newsapp.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class NewsResponse {
    @SerializedName("articles")
    private List<News> news;
}
