package com.example.rany.room_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rany.room_demo.adapter.ArticleAdapter;
import com.example.rany.room_demo.data.local.room.dao.ArticleDao;
import com.example.rany.room_demo.data.local.room.db.ArticleDatabase;
import com.example.rany.room_demo.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {

    List<Article> articles=new ArrayList<>();
    RecyclerView rvArticle;
    ArticleAdapter adapter;
    ArticleDao articleDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        rvArticle=findViewById(R.id.rvArticle);
        articleDao= ArticleDatabase.getDatabase(this).getArticleDao();
        rvArticle.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ArticleAdapter(articles);
        rvArticle.setAdapter(adapter);
        updateData();
    }

    private void updateData() {
        adapter.setArticles(articleDao.getAllArticle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addArticle:
                startActivity(new Intent(this,AddArticleActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
