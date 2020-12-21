package com.nsu.fit.newsapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.nsu.fit.newsapp.R;
import com.nsu.fit.newsapp.network.News;

import java.util.Objects;

public class NewsAdapter extends PagedListAdapter<News, NewsViewHolder> {

    public NewsAdapter() {
        super(new DiffUtil.ItemCallback<News>() {

            @Override
            public boolean areItemsTheSame(@NonNull News oldItem, @NonNull News newItem) {
                return oldItem.getTitle().equals(newItem.getTitle());
            }

            @Override
            public boolean areContentsTheSame(@NonNull News oldItem, @NonNull News newItem) {
                return Objects.equals(oldItem.getDescription(), newItem.getDescription())
                        && Objects.equals(oldItem.getImage(), newItem.getImage());
            }
        });
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final News news = getItem(position);
        if (news != null) {
            holder.bindTo(news);
        } else {
            holder.clear();
        }
    }
}
