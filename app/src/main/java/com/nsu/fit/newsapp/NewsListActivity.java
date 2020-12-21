package com.nsu.fit.newsapp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nsu.fit.newsapp.model.NewsViewModel;
import com.nsu.fit.newsapp.view.NewsAdapter;

public class NewsListActivity extends AppCompatActivity {
    private final NewsAdapter newsAdapter = new NewsAdapter();
    private NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsViewModel = new ViewModelProvider.NewInstanceFactory()
                .create(NewsViewModel.class);
        newsViewModel.getNewsLiveData().observe(this, newsAdapter::submitList);

        setRecyclerView();
    }

    private void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.news_list);
        int orientation = getResources().getConfiguration().orientation;
        RecyclerView.LayoutManager layoutManager;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            layoutManager = linearLayoutManager;
        } else {
            layoutManager = new GridLayoutManager(this, 2);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newsAdapter);

    }
}
