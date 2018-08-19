package com.example.rany.room_demo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rany.room_demo.R;
import com.example.rany.room_demo.entity.Article;

import org.w3c.dom.Text;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{

    List<Article> articles;
    private static final String TAG = "ArticleAdapter";
    public ArticleAdapter(List<Article> articles) {
        this.articles = articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles.addAll(articles);
        Log.e(TAG, "setArticles: "+this.articles.size() );
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.article_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article=this.articles.get(position);
        holder.title.setText(article.title);
        holder.content.setText(article.content);
    }

    @Override
    public int getItemCount() {
        return this.articles.size();
    }

    static  class  ViewHolder extends RecyclerView.ViewHolder{
        TextView title, content;
        public ViewHolder(View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.artTitle);
            content=itemView.findViewById(R.id.artContent);
        }
    }
}
