package com.nsu.fit.newsapp.network;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

@Data
public class News implements Serializable {
    private String title;

    @SerializedName("urlToImage")
    private String image;

    private String description;
}
