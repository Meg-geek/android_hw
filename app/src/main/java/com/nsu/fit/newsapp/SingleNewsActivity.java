package com.nsu.fit.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nsu.fit.newsapp.network.News;
import com.nsu.fit.newsapp.view.NewsViewHolder;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

public class SingleNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_news);
        fillNewsInfo();
    }

    private void fillNewsInfo() {
        News news = (News) getIntent().getSerializableExtra(NewsViewHolder.NEWS_TAG);
        if (news == null) {
            Log.e("SingleNewsActivity", "News object not found");
            return;
        }
        TextView title = findViewById(R.id.text_single_news_title);
        title.setText(news.getTitle());
        TextView description = findViewById(R.id.text_single_news_description);
        description.setText(news.getDescription());
        if (StringUtils.isNotBlank(news.getImage())) {
            ImageView image = findViewById(R.id.image_single_news);
            Picasso.get().load(news.getImage()).into(image);
        }
    }

}
