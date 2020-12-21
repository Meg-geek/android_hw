package com.nsu.fit.newsapp.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nsu.fit.newsapp.R;
import com.nsu.fit.newsapp.SingleNewsActivity;
import com.nsu.fit.newsapp.network.News;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    public final static String NEWS_TAG = "news";
    private final TextView newsTitle;
    private final ImageView newsImage;

    NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        newsTitle = itemView.findViewById(R.id.text_news_title);
        newsImage = itemView.findViewById(R.id.image_news);
    }

    void bindTo(News news) {
        newsTitle.setText(news.getTitle());
        String imageUrl = news.getImage();
        if (StringUtils.isNotBlank(imageUrl)) {
            Picasso.get().load(imageUrl).into(newsImage);
        }

        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(itemView.getContext(), SingleNewsActivity.class);
            intent.putExtra(NEWS_TAG, news);
            itemView.getContext().startActivity(intent);
        });
    }

    void clear() {
        newsTitle.setText("");
        newsImage.setImageDrawable(null);
    }
}
